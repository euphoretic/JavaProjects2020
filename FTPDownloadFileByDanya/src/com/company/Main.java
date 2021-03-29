package com.company;

import java.io.*;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.io.Util;

public class Main {
    private static File tempFile;

    public static void main(String[] args) {
        String server = "gaia.cs.umass.edu";
        int port = 21;
        String user = "anonymous";
        String pass = "password";
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            boolean s = ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            String remoteFile2 = "/pub/#README#";
            File downloadFile2 = new File("C:/Users/danim/Downloads/README");
            OutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream(downloadFile2));
            InputStream inputStream = ftpClient.retrieveFileStream(remoteFile2);
            String a = ftpClient.getReplyString();
            System.out.println(a);
            byte[] bytesArray = new byte[4096];

            int bytesRead = -1;
            while ((bytesRead = inputStream.read(bytesArray)) != -1) {
                outputStream2.write(bytesArray, 0, bytesRead);
            }
            boolean success = ftpClient.completePendingCommand();
            if (success) {
                System.out.println("File has been downloaded successfully.");
            } outputStream2.close();
            inputStream.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) { ex.printStackTrace(); }
        }
    }
}
