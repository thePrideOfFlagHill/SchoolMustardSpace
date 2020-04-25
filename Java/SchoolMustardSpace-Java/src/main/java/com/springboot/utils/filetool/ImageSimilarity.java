package com.springboot.utils.filetool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


/**
 * 比较两张图片的相似度
 */

public class ImageSimilarity {

    // 改变成二进制码
    public static String[][] getPX(String args) {
        int[] rgb = new int[3];
        File file = new File(args);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int width = bi.getWidth();
        int height = bi.getHeight();
        int minx = bi.getMinX();
        int miny = bi.getMinY();
        String[][] list = new String[width][height];
        for (int i = minx; i < width; i++) {
            for (int j = miny; j < height; j++) {
                int pixel = bi.getRGB(i, j);
                rgb[0] = (pixel & 0xff0000) >> 16;
                rgb[1] = (pixel & 0xff00) >> 8;
                rgb[2] = (pixel & 0xff);
                list[i][j] = rgb[0] + "," + rgb[1] + "," + rgb[2];
            }
        }
        return list;
    }

    public static int compareImage(String imgPath1, String imgPath2){
        String[] images = {imgPath1, imgPath2};
        if (images.length == 0) {
            System.exit(0);
        }
        // 分析图片相似度 begin
        String[][] list1 = getPX(images[0]);
        String[][] list2 = getPX(images[1]);
        int same = 0;
        int different = 0;
        int i = 0, j = 0;
        for (String[] strings : list1) {
            if ((i + 1) == list1.length) {
                continue;
            }
            for (int m=0; m<strings.length; m++) {
                try {
                    String[] value1 = list1[i][j].toString().split(",");
                    String[] value2 = list2[i][j].toString().split(",");
                    int k = 0;
                    for (int n=0; n<value2.length; n++) {
                        if (Math.abs(Integer.parseInt(value1[k]) - Integer.parseInt(value2[k])) < 5) {
                            same++;
                        } else {
                            different++;
                        }
                    }
                } catch (RuntimeException e) {
                    continue;
                }
                j++;
            }
            i++;
        }
        list1 = getPX(images[1]);
        list2 = getPX(images[0]);
        i = 0;
        j = 0;
        for (String[] strings : list1) {
            if ((i + 1) == list1.length) {
                continue;
            }
            for (int m=0; m<strings.length; m++) {
                try {
                    String[] value1 = list1[i][j].toString().split(",");
                    String[] value2 = list2[i][j].toString().split(",");
                    int k = 0;
                    for (int n=0; n<value2.length; n++) {
                        if (Math.abs(Integer.parseInt(value1[k]) - Integer.parseInt(value2[k])) < 5) {
                            same++;
                        } else {
                            different++;
                        }
                    }
                } catch (RuntimeException e) {
                    continue;
                }
                j++;
            }
            i++;
        }
        String percentage = "";
        try {
            percentage = ((Double.parseDouble(same + "") / Double.parseDouble((different + same) + "")) + "");
            percentage = percentage.substring(percentage.indexOf(".") + 1, percentage.indexOf(".") + 3);
        } catch (Exception e) {
            percentage = "0";
        }
        if (percentage.length() <= 0) {
            percentage = "0";
        }
        if(different == 0){
            percentage="100";
        }
        System.out.println("相似像素数量：" + same + " 不相似像素数量：" + different + " 相似率：" + Integer.parseInt(percentage) + "%");
        return Integer.parseInt(percentage);
    }
    public static void main(String[] args){
        ImageSimilarity.compareImage("D:\\1.jpg", "D:\\2.jpg");
    }
}

