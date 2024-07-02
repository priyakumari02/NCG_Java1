package com.adobe.prj.dao;

import java.util.ResourceBundle;

public class MobileDaoFactory {
    private static String MOBILE_DAO ="";

    static  {
        ResourceBundle res = ResourceBundle.getBundle("config");
        MOBILE_DAO = res.getString("MOBILE_DAO");
    }
    public static MobileDao getMobileDao() {
       // return  new MobileDaoFileImpl();
        try {
           return (MobileDao) Class.forName(MOBILE_DAO).getConstructor().newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
