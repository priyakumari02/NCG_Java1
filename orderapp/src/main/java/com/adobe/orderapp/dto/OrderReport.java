package com.adobe.orderapp.dto;

import java.util.Date;

public record OrderReport(String firstName, Date orderDate, double total) {
}
