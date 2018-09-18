package com.example.nam.donationmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.transferwise.sequencelayout.SequenceStep;

public class DetailStep extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        SequenceStep sequenceStepFirst = (SequenceStep)findViewById(R.id.Sequence_step1);
        SequenceStep sequenceStepSecond = (SequenceStep)findViewById(R.id.Sequence_step2);
        SequenceStep sequenceStepThird = (SequenceStep)findViewById(R.id.Sequence_step3);
        SequenceStep sequenceStepFourth = (SequenceStep)findViewById(R.id.Sequence_step4);
        SequenceStep sequenceStepFifth = (SequenceStep)findViewById(R.id.Sequence_step5);

        sequenceStepFirst.setAnchor("사용자의 기부날짜 UPDATE");
        sequenceStepFirst.setTitle("사용자 기부");



        sequenceStepSecond.setAnchor("Today");
        sequenceStepSecond.setTitle("Donating BK 처리");
        sequenceStepSecond.setActive(true);

        sequenceStepThird.setAnchor("미정");
        sequenceStepThird.setTitle("기부단체");
        sequenceStepThird.setSubtitle("기부단체에서 확인하여 처리중입니다.");

        sequenceStepFourth.setTitle("기부 진행중");

        sequenceStepFifth.setTitle("기부완료");


    }

}