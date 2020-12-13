package com.mcmin.utils.ssh;

public class TestSSH {
    private static final String ip= "127.0.0.1";
    private static final int port = 22;
    private static final String sshUser = "root";
    private static final String sshPasswd = "mcmin";

    public static void main(String[] args) {
        SSHCommandExecutor sshCommandExecutor = new SSHCommandExecutor(ip, port, sshUser, sshPasswd);

        sshCommandExecutor.connect();
        String result = sshCommandExecutor.executeCommand("ls /");

        System.out.println(result);
    }
}
