package com.geektime;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class HelloClassLoader extends ClassLoader {

    private String byteCodePath;

    public HelloClassLoader(String byteCodePath){
        this.byteCodePath = byteCodePath;
    }


    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        BufferedInputStream bufferedInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {

            //获取字节码的完整路径
            String fileName=byteCodePath + className + ".xlass";

            //获取一个输入流
            bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName));

            //获取一个输出流
            byteArrayOutputStream = new ByteArrayOutputStream();

            //具体读入数据并写出的过程
            int len;
            byte[] data = new byte[1];
            byte[] transData= new byte[1];
            byte b255 = (byte) 255;

            while((len = bufferedInputStream.read(data)) != -1){
                transData[0] = (byte)(b255-data[0]);
                byteArrayOutputStream.write(transData,0,len);
            }
            //获取内存中的完整的字节数组的数据
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            //将字节数组的数据转换为Class的实例。
            Class<?> clazz = defineClass(null, byteArray, 0, byteArray.length);
            return clazz;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(byteArrayOutputStream != null)
                    byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bufferedInputStream != null)
                    bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
