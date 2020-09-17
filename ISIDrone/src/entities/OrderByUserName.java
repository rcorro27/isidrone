/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author ybenhail
 */
public class OrderByUserName {
    private int id,isShipped;
    private String nameUser;
    private Date dateOrder;

    public int getIsShipped() {
        return isShipped;
    }

    public void setIsShipped(int isShipped) {
        this.isShipped = isShipped;
    }

    public OrderByUserName(int id, String nameUser, Date dateOrder, int isShipped) {
        this.id = id;
        this.isShipped = isShipped;
        this.nameUser = nameUser;
        this.dateOrder = dateOrder;
    }

    public OrderByUserName(int id, String nameUser, Date dateOrder) {
        this.id = id;
        this.nameUser = nameUser;
        this.dateOrder = dateOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public OrderByUserName() {
    }
    
    
    
}
