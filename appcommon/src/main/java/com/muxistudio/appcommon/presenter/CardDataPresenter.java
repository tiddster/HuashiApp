package com.muxistudio.appcommon.presenter;

import com.muxistudio.appcommon.data.CardAccount;
import com.muxistudio.appcommon.data.CardBalance;
import com.muxistudio.appcommon.data.CardDailyUse;
import com.muxistudio.appcommon.data.CardDataEtp;
import com.muxistudio.appcommon.net.CampusFactory;
import com.muxistudio.appcommon.view.ICardView;
import com.muxistudio.common.util.DateUtil;

import java.util.Calendar;
import java.util.Date;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CardDataPresenter {

    private CardDataEtp mCardDataEtp;
    private CardBalance mCardBalance = new CardBalance();

    private ICardView iCardView;

    public CardDataPresenter(ICardView view) {
        this.iCardView = view;
    }

    public Observable<CardBalance> getCardObservable() {
        return CampusFactory.getRetrofitService().getCardBalance()
                .subscribeOn(Schedulers.io());
    }

    public void setCardView() {
        getCardObservable().observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CardBalance>() {
                    @Override
                    public void onCompleted() {

                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR));
                        Date today = calendar.getTime();
                        String todayDays = DateUtil.toDateInYear(today);

                        CampusFactory.getRetrofitService().getCardAccount("300", "1", "2018-09-01", todayDays)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Observer<CardAccount>() {
                                    @Override
                                    public void onCompleted() {

                                    }

                                    @Override
                                    public void onError(Throwable e) {

                                    }

                                    @Override
                                    public void onNext(CardAccount cardAccount) {

                                        //CardDailyUse use = CardDailyUse.convert(cardAccount);
                                        if (iCardView != null)
                                            iCardView.initView(cardAccount, mCardBalance);
                                          //  iCardView.initView(use, mCardDataEtp);
                                    }
                                });
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CardBalance cardBalance) {
                        //System.out.print(cardBalance.toString());
                        mCardBalance = cardBalance;
                        //mCardDataEtp = CardDataEtp.convert(cardBalance);
                        //System.out.print(mCardDataEtp.toString());
                    }
                });
    }

}
