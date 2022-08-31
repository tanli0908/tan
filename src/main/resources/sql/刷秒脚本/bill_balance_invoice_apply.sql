UPDATE bill_balance_invoice_apply SET update_time=SUBDATE(update_time,INTERVAL -1 SECOND)  WHERE  date_format(update_time,'%Y-%m')= '2022-06';
UPDATE bill_balance_invoice_apply SET update_time=SUBDATE(update_time,INTERVAL -1 SECOND)  WHERE  date_format(update_time,'%Y-%m')= '2022-07';
UPDATE bill_balance_invoice_apply SET update_time=SUBDATE(update_time,INTERVAL -1 SECOND)  WHERE  date_format(update_time,'%Y-%m')= '2022-08';
