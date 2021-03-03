package com.tan.com.tan.javatools.freemarker.outfile;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName sds
 * @Description TODO
 * @Author Tan.li
 * @Date 2021-02-09
 * @Since 1.0
 */
public class sds {

    /**'主键ID,uuid生成*/
    private String id;
    /**'订单编号*/
    private String orderNo;
    /**'特卖备货单号*/
    private String refBillNo;
    /**'销售门店编码*/
    private String shopNo;
    /**'销售门店*/
    private String shopName;
    /**'调货(转货)门店编码*/
    private String shopNoFrom;
    /**'调货(转货)门店*/
    private String shopNameFrom;
    /**'商品SKU*/
    private String skuNo;
    /**'商品内码*/
    private String itemNo;
    /**'商品尺码*/
    private String sizeNo;
    /**'商品编号*/
    private String itemCode;
    /**'商品名称*/
    private String itemName;
    /**'商品条码*/
    private String barcode;
    /**'所属品牌*/
    private String brandNo;
    /**'品牌部编号*/
    private String brandUnitNo;
    /**'品牌部名称*/
    private String brandUnitName;
    /**2006~2026,默认当年)*/
    private String years;
    /**'片区编码*/
    private String regionNo;
    /**'片区名称*/
    private String regionName;
    /**'明细备注*/
    private String remark;
    /**促销标识,2-不使用*/
    private Byte itemFlag;
    /**'商品牌价*/
    private BigDecimal tagPrice;
    /**'全国统一牌价*/
    private BigDecimal tagPriceNation;
    /**'商品现价*/
    private BigDecimal salePrice;
    /**'商品折扣价*/
    private BigDecimal discPrice;
    /**'商品结算价*/
    private BigDecimal settlePrice;
    /**'减价,单价减价*/
    private BigDecimal reducePrice;
    /**'外卡折让金额*/
    private BigDecimal rebateAmount;
    /**'积分兑换金额*/
    private BigDecimal scoreAmount;
    /**'商品数量*/
    private Integer qty;
    /**'商品总金额,(结算价-减价)*数量*/
    private BigDecimal amount;
    /**'总部成本*/
    private BigDecimal headquarterCost;
    /**'地区成本*/
    private BigDecimal regionCost;
    /**'单位成本*/
    private BigDecimal unitCost;
    /**'采购价*/
    private BigDecimal purchasePrice;
    /**'物料价*/
    private BigDecimal materialPrice;
    /**'厂进价*/
    private BigDecimal factoryPrice;
    /**'促销优惠单价,促销优惠单价*/
    private BigDecimal prefPrice;
    /**'促销活动编号，多个以逗号隔开*/
    private String proNo;
    /**'促销活动名称，多个以逗号隔开*/
    private String proName;
    /**1-特卖*/
    private Byte specialSellFlag;
    /**'最终扣率,如17.00代表17.00%*/
    private BigDecimal discount;
    /**'扣率代码，如A,B*/
    private String discountCode;
    /**'扣率名称*/
    private String discountName;
    /**3-促销扣率),0-不使用,6-不使用*/
    private Byte discountType;
    /**'最终扣率来源名称*/
    private String discountTypeName;
    /**'最终扣率来源编号*/
    private String discountSourceId;
    /**'商场结算码*/
    private String billingCode;
    /**4-其他,0-不使用,50-订单来源(从pos.sysStandard(主表)获取,80-订单来源(从pos.sysStandard(主表)获取,100-订单来源(从pos.sysStandard(主表)获取*/
    private Byte properties;
    /**1-实数*/
    private Byte virtualFlag;
    /**'力度*/
    private BigDecimal strength;
    /**'活动类型名称*/
    private String activityTypeName;
    /**'活动类型*/
    private Byte activityType;
    /**'发起方式名称*/
    private String launchTypeName;
    /**2-品牌公司发起,4-不使用*/
    private Byte launchType;
    /**'活动结束时间*/
    private Date proEndTime;
    /**'活动开始时间*/
    private Date proStartTime;
    /**1-牌价金额,5-不使用,64-不使用*/
    private Byte balanceBase;
    /**'会员折数*/
    private BigDecimal vipDiscount;
    /**'会员等级名称*/
    private String vipLevelName;
    /**'会员等级Code*/
    private String vipLevelCode;
    /**'基本积分*/
    private Integer baseScore;
    /**'整单分摊积分*/
    private Integer proScore;
    /**'消费积分*/
    private Integer costScore;
    /**'商品折数,如25.00代表25.00%*/
    private BigDecimal itemDiscount;
    /**'颜色编码*/
    private String colorNo;
    /**'颜色名称*/
    private String colorName;
    /**'品牌名称*/
    private String brandName;
    /**'减价原因,当减价不为空，减价原因必填*/
    private String reducePriceReason;
    /**'改单改价分类名称*/
    private String reasonClassName;
    /**'改单改价分类编号*/
    private String reasonClassNo;
    /**'原因编码*/
    private String reasonCode;
    /**'尺码种类*/
    private String sizeKind;
    /**'类别编码*/
    private String categoryNo;
    /**'店转货单号,只有跨店销售（本店自提）才有数据*/
    private String billTransferNo;
    /**'变价单单号*/
    private String priceChangeBillNo;
    /**'退换货数量，该条明细退换货数量*/
    private Short returnExchangeNum;
    /**'大区年月*/
    private String zoneYyyymm;
    /**1-是*/
    private Byte acrossSaleFlag;
    /**1-指定扣率,3-订单来源(从pos.sysStandard(主表)获取*/
    private Byte specifiedDiscountFlag;
    /**4-已提已扣(预留)*/
    private Byte pickupStatus;
    /**3-跨店销售*/
    private Byte takeOffType;
    /**'明细提货人*/
    private String pickupUser;
    /**'明细提货人编号*/
    private String pickupUserNo;
    /**'明细提货时间。非欠客-收银出库时间；欠客-提货时间*/
    private Date pickupTime;
    /**'发票号(MPS),多个用逗号(,)分隔*/
    private String invoiceNo;
    /**'实际销售金额(优惠券价值+结算金额)*/
    private BigDecimal actualAmount;
    /**'券实收金额分摊额(优惠券优惠金额)*/
    private BigDecimal realBuyAmount;
    /**'用券金额(优惠券价值)*/
    private BigDecimal surplusAmount;
    /**'促销折扣*/
    private BigDecimal rateDiscount;
    /**默认30,20-不使用*/
    private Byte dtlRefundStatus;
    /**'建档人姓名*/
    private String createUser;
    /**'建档时间*/
    private Date createTime;
    /**'最后修改人姓名*/
    private String updateUser;
    /**'修改时间*/
    private Date updateTime;
    /**'总账时间*/
    private Date glDate;
    /**'分库字段*/
    private String shardingFlag;
    /**'款号*/
    private String styleNo;
    /**'改价状态：0：正常，1：手动改价，2：申请改价*/
    private Byte changeState;
    /**'改价审核状态：0：正常，1：未审核，2：已审核,3-不使用*/
    private Byte changeAuditState;
    /**'改价审核人*/
    private String changeStateAuditUser;
    /**'改价审核时间*/
    private Date changeStateAuditTime;
    /**'并行活动时所使用的扣率的活动编码*/
    private String rateProNo;
    /**'并行活动时所使用的扣率的活动名称*/
    private String rateProName;
    /**'经营城市编号*/
    private String bizCityNo;
    /**'经营城市名称*/
    private String bizCityName;
    /**'管理城市编号*/
    private String organNo;
    /**'管理城市名称*/
    private String organName;
    /**'大区编码(有且必须只能输入一位)*/
    private String zoneCode;
    /**'大区名称*/
    private String zoneName;
    /**'款式编码(体育)*/
    private String itemStyleNo;
    /**'系列编码(体育)*/
    private String itemSeriesNo;
    /**'管理区域编码*/
    private String managementAreaNo;
    /**'管理区域名称*/
    private String managementAreaName;
    /**1-已接，2-未接,3-拒绝接单,4-待派单*/
    private Integer orderTaking;
    /**'快递单号*/
    private String expressNo;
    /**'物流公司编号*/
    private String logisticsNo;
    /**'物流名称*/
    private String logisticsName;
    /**'短信验证码*/
    private String messageCode;
    /**'提货经办人名称*/
    private String checkUser;
    /**'提货经办人编号*/
    private String checkUserNo;
    /**'提货日期*/
    private Date pickupDate;
    /**'开票金额*/
    private BigDecimal billingAmount;
    /**'代销结算价*/
    private BigDecimal saleproxyAmount;
    /**'受托代销公司编号*/
    private String buyerNo;
    /**'受托代销公司名称*/
    private String buyerName;
    /**'客户成交价*/
    private BigDecimal customerSettlePrice;
    /**'是否买断商品,0,不是;1,是;*/
    private Byte isBuyOut;
    /**'FAS的业务类型.0:正常单.1:代销单*/
    private Byte financeType;
    /**'pos初始amount值*/
    private BigDecimal originalAmount;
    /**'fas记录更新时间*/
    private Date fasUpdateTime;
    /**'供货价*/
    private BigDecimal supplyPrice;
    /**'快递入站时间*/
    private Date expressInboundTime;
    /**'对应主表outDa*/
    private Date mainOutDate;

}
