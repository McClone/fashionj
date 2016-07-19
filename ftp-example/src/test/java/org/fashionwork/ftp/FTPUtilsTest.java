package org.fashionwork.ftp;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author zhengsd
 */
public class FTPUtilsTest {

    @Test
    public void downloadFile() throws Exception {
        FTPUtils.downloadFile("127.0.0.1", 21, "ftp-user", "123", "/test", "test.txt", "D:/download");
    }

    @Test
    public void uploadFile() throws Exception {
        FileInputStream in = new FileInputStream(new File("D:/test.txt"));
        boolean flag = FTPUtils.uploadFile("127.0.0.1", 21, "ftp-user", "123", "test.txt", "/test", in);
        System.out.println(flag);
    }

}