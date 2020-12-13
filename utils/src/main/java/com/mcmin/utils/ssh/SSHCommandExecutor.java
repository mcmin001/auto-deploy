package com.mcmin.utils.ssh;

import com.jcraft.jsch.*;
import com.mcmin.autodeploy.common.utils.CloseResourceUtil;
import com.mcmin.utils.ssh.sftp.FileProgressMonitor;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * to see:https://blog.csdn.net/coding99/article/details/52416373
 */
public class SSHCommandExecutor implements Closeable {
    private String ip;
    private int sshPort;
    private String sshUser;
    private String sshPwd;

    private JSch jsch;

    private DeploySshUseInfo deploySshUseInfo;

    private Session session;
    //private Channel channel;

    public SSHCommandExecutor(){

    }

    public SSHCommandExecutor(String ip , int sshPort, String sshUser, String sshPwd){
        this.ip = ip;
        this.sshPort = sshPort;
        this.sshUser = sshUser;
        this.sshPwd = sshPwd;
    }

    public void connect(){
         jsch = new JSch();
        try{
            session = jsch.getSession(sshUser, ip, sshPort);
            session.setPassword(sshPwd);
            // username and password will be given via UserInfo interface.
            session.setUserInfo(new DeploySshUseInfo());

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);// 为Session对象设置properties
            session.setTimeout(6000);//设置连接超时时间
            session.connect();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 执行命令
     * @param command
     * @return
     */
    public String executeCommand(String command){
        if(!session.isConnected()){
            throw new IllegalStateException("ssh session to " + ip + ":" + sshPort + " is disconnect .");
        }

        System.out.println("will exec command:" + command);

        //脚本返回结果
        StringBuilder result = new StringBuilder();
        BufferedReader reader = null;
        InputStream in = null;

        Channel channel = null;

        //脚本执行退出状态码
        int returnCode = -2;

        try {
            channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
            //执行命令 等待执行结束
            channel.connect();
            in = channel.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in, Charset.forName("utf-8")));

            String res = "";

            while((res = reader.readLine()) != null){
                result.append(res+"\n");
            }

            returnCode = channel.getExitStatus();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            channel.disconnect();
            CloseResourceUtil.close(reader, in);
        }

        return result.toString();
    }

    public void upload(String srcFilePath, String uploadDir){
        Channel channel = null;

        OutputStream out = null;

        ChannelSftp channelSftp = null;
        try{
            channel = session.openChannel("sftp");
            channel.connect();

            channelSftp = (ChannelSftp) channel;

            File file = new File(srcFilePath);
            long fileSize = file.length();

            out = channelSftp.put(uploadDir, new FileProgressMonitor(fileSize), ChannelSftp.OVERWRITE);

            byte[] buff = new byte[1024 * 256]; // 设定每次传输的数据块大小为256KB
            int read;
            if (out != null) {
                System.out.println("Start to read input stream");
                InputStream is = new FileInputStream(uploadDir);
                do {
                    read = is.read(buff, 0, buff.length);
                    if (read > 0) {
                        out.write(buff, 0, read);
                    }
                    out.flush();
                } while (read >= 0);
                System.out.println("input stream read done.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != channelSftp){
                channelSftp.quit();
            }
            if(null != channel){
                channel.disconnect();
            }
        }
    }

    @Override
    public void close() throws IOException {
        if(null != session){
            session.disconnect();
        }
    }

    class DeploySshUseInfo implements UserInfo{

        @Override
        public String getPassphrase() {
            return null;
        }

        @Override
        public String getPassword() {
            return null;
        }

        @Override
        public boolean promptPassword(String s) {
            return false;
        }

        @Override
        public boolean promptPassphrase(String s) {
            return false;
        }

        @Override
        public boolean promptYesNo(String s) {
            return false;
        }

        @Override
        public void showMessage(String s) {

        }
    }
}
