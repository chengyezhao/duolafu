package com.shoumipay.tools;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shoumipay.domain.BankAccount;

import java.io.*;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;

/**
 * xinjiandai
 */
public class CsvUtil {
    private String fileName = null;
    private BufferedReader br = null;
    private List<String> list = new ArrayList<String>();

    public CsvUtil() {

    }

    public CsvUtil(String fileName) throws Exception {
        this.fileName = fileName;
       // br = new BufferedReader(new FileReader(fileName));
        br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"gbk"));
        String stemp;
        while ((stemp = br.readLine()) != null) {
            stemp = stemp.replace("\uFEFF","");
            list.add(stemp);
        }
    }

    public List getList() {
        return list;
    }
    /**
     * 获取行数
     * @return
     */
    public int getRowNum() {
        return list.size();
    }
    /**
     * 获取列数
     * @return
     */
    public int getColNum() {
        if (!list.toString().equals("[]")) {
            if (list.get(0).toString().contains(",")) {// csv为逗号分隔文件
                return list.get(0).toString().split(",").length;
            } else if (list.get(0).toString().trim().length() != 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
    /**
     * 获取制定行
     * @param index
     * @return
     */
    public String getRow(int index) {
        if (this.list.size() != 0) {
            return (String) list.get(index);
        } else {
            return null;
        }
    }
    /**
     * 获取指定列
     * @param index
     * @return
     */
    public String getCol(int index) {
        if (this.getColNum() == 0) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        String tmp = null;
        int colnum = this.getColNum();
        if (colnum > 1) {
            for (Iterator it = list.iterator(); it.hasNext();) {
                tmp = it.next().toString();
                sb = sb.append(tmp.split(",")[index] + ",");
            }
        } else {
            for (Iterator it = list.iterator(); it.hasNext();) {
                tmp = it.next().toString();
                sb = sb.append(tmp + ",");
            }
        }
        String str = new String(sb.toString());
        str = str.substring(0, str.length() - 1);
        return str;
    }
    /**
     * 获取某个单元格
     * @param row
     * @param col
     * @return
     */
    public String getString(int row, int col) {
        String temp = null;
        int colnum = this.getColNum();
        if (colnum > 1) {
            temp = list.get(row).toString().split(",")[col];
        } else if(colnum == 1){
            temp = list.get(row).toString();
        } else {
            temp = null;
        }
        return temp;
    }

    public void CsvClose()throws Exception{
        this.br.close();
    }
    /**
     *去表头
     **/
    public String removehead(String str){
        String[] str_1=str.split(",");
        String sb=new String();
        for(int i=1;i<str_1.length;i++){
            sb=sb+str_1[i]+",";
        }
        return sb;
    }
    public static String[] readcsv(String path){
        JSONArray array=new JSONArray();
        CsvUtil util;
        String[] str = null;
        try {
            util = new CsvUtil(path);
            int row=util.getRowNum();
            int col=util.getColNum();
            str = new String[col];
            for(int i=0;i<col;i++){
                JSONObject jsonobject=new JSONObject();
                String value=util.getCol(i);
                str[i]=util.removehead(value);
                /*jsonobject.put(util.getString(0, i),util.removehead(value));
                array.add(jsonobject);*/
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }
    public static void main(String[] args){
     /*   CsvUtil util;
        try{
            util = new CsvUtil("E:/test1/FKMX_201711010001092244_20171122.csv");
            int rowNum = util.list.size();
            int colNum = util.getColNum();
            String[] str = new String[colNum];
            for(int i=1;i<rowNum;i++){
                for(int j = 0;j<colNum;j++){
                     str[j] = util.getString(i,j);
                }
                System.out.println(str);
            }
        } catch (Exception e){
            e.printStackTrace();
        }*/


        /*String[] str = CsvUtil.readcsv("E:/test1/JYMX_201711010001092244_20171122.csv");
        String[] onestr = str[0].replace("=","").split(",");
        for(int i = 0;i<onestr.length;i++){
            String[] onedate = new String[str.length];
            for (int j =0;j<str.length;j++){
                    String oneLie = str[j];
                    onedate[j] = oneLie.replace("=","").split(",")[i];
            }
            BankAccount bankAccount = new BankAccount(new Date(),onedate[0],onedate[1],DateUtil.parse(onedate[2],DateUtil.DEFAULT_DATE_TIME3)
                    ,onedate[3],onedate[4],DateUtil.parse(onedate[5],DateUtil.DEFAULT_DAY_DATE), BigDecimal.valueOf(Double.parseDouble(onedate[6])),
                    Integer.parseInt(onedate[7]),Integer.parseInt(onedate[8]),DateUtil.parse(onedate[9],DateUtil.DEFAULT_DATE_TIME3),BigDecimal.valueOf(Double.parseDouble(onedate[10])),
                    onedate[11],onedate[12],onedate[13],null,null,null);
        }*/
    }
}

