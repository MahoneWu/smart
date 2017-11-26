package org.mouse.spring.targetsourcedemo;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.math.IntRange;

/**
 * Created by Mahone Wu on 2017/11/17.
 */
public class AnyMethodInterceptor implements MethodInterceptor {


    private static final Integer DEFAULT_DISCOUNT_RATIO = 80;

    private static final IntRange RATIO_RANGE = new IntRange(5, 95);


    private Integer discountRatio = DEFAULT_DISCOUNT_RATIO;
    private boolean campaignAvailable;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println(invocation.getMethod());
        Object returnValue = invocation.proceed();
        if(RATIO_RANGE.containsInteger(getDiscountRatio()) && isCampaignAvailable()){
            return ((Integer) returnValue) * getDiscountRatio() / 100;
        }
        return returnValue;
    }

    public Integer getDiscountRatio() {
        return discountRatio;
    }

    public void setDiscountRatio(Integer discountRatio) {
        this.discountRatio = discountRatio;
    }

    public boolean isCampaignAvailable() {
        return campaignAvailable;
    }

    public void setCampaignAvailable(boolean campaignAvailable) {
        this.campaignAvailable = campaignAvailable;
    }
}
