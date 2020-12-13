package com.mcmin.utils.ssh.sftp;

import com.jcraft.jsch.SftpProgressMonitor;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

public class FileProgressMonitor extends TimerTask implements SftpProgressMonitor {

    //默认间隔时间为5秒
    private long progressInterval = 5 * 1000;

    //记录传输是否结束
    private boolean isEnd = false;

    //记录已传输的数据总大小
    private long transfered;

    //记录文件总大小
    private long fileSize;

    //定时器对象
    private Timer timer;

    //记录是否已启动timer记时器
    private boolean isScheduled = false;

    public FileProgressMonitor(long fileSize){
        this.fileSize = fileSize;
    }

    @Override
    public void init(int i, String s, String s1, long l) {

    }

    public void start(){
        System.out.println("Try to start progress monitor.");
        if (timer == null) {
            timer = new Timer();
        }
        timer.schedule(this, 1000, progressInterval);
        isScheduled = true;
        System.out.println("Progress monitor started.");
    }

    public void stop() {
        System.out.println("Try to stop progress monitor.");
        if (timer != null) {
            timer.cancel();
            timer.purge();
            timer = null;
            isScheduled = false;
        }
        System.out.println("Progress monitor stoped.");
    }

    @Override
    public boolean count(long count) {
        if (isEnd()) return false;
        if (!isScheduled) {
            start();
        }
        add(count);
        return true;
    }

    @Override
    public void end() {
        setEnd(true);
        System.out.println("transfering end.");
    }

    private synchronized void add(long count) {
        transfered = transfered + count;
    }

    @Override
    public void run() {
        if (!isEnd()) { // 判断传输是否已结束

            System.out.println("Transfering is in progress.");

            long transfered = getTransfered();

            if (transfered != fileSize) { // 判断当前已传输数据大小是否等于文件总大小
                System.out.println("Current transfered: " + transfered + " bytes");
                sendProgressMessage(transfered);
            } else {
                System.out.println("File transfering is done.");
                setEnd(true); // 如果当前已传输数据大小等于文件总大小，说明已完成，设置end
            }
        } else {
            System.out.println("Transfering done. Cancel timer.");
            stop(); // 如果传输结束，停止timer记时器
            return;
        }
    }

    private void sendProgressMessage(long transfered) {
        if (fileSize != 0) {
            double d = ((double)transfered * 100)/(double)fileSize;
            DecimalFormat df = new DecimalFormat( "#.##");
            System.out.println("Sending progress message: " + df.format(d) + "%");
        } else {
            System.out.println("Sending progress message: " + transfered);
        }
    }

    public long getProgressInterval() {
        return progressInterval;
    }

    public void setProgressInterval(long progressInterval) {
        this.progressInterval = progressInterval;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public long getTransfered() {
        return transfered;
    }

    public void setTransfered(long transfered) {
        this.transfered = transfered;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public boolean isScheduled() {
        return isScheduled;
    }

    public void setScheduled(boolean scheduled) {
        isScheduled = scheduled;
    }
}
