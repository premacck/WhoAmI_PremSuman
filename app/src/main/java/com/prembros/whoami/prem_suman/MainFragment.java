package com.prembros.whoami.prem_suman;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

public class MainFragment extends Fragment implements BaseSliderView.OnSliderClickListener{

    private static final String ARG_PARAM = "param";
    private String mParam1;
    SliderLayout sliderLayout;
    ScrollView scrollView;

//    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

//    public static MainFragment newInstance(String param1) {
//        MainFragment fragment = new MainFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.web_view, container, false);
        HashMap<String, String> hashMap_photos = new HashMap<>();
        sliderLayout = (SliderLayout) rootView.findViewById(R.id.slider);
        scrollView = (ScrollView) rootView.findViewById(R.id.social_handles);

        if (mParam1 != null){
            switch (mParam1){
                case "certificates":
                    hashMap_photos.put("Android App Development", "http://imgur.com/L8eczeM.jpg");
                    hashMap_photos.put("Core Java 1", "http://imgur.com/rlBco4P.jpg");
                    hashMap_photos.put("Core Java 2", "http://imgur.com/6IJg3d9.jpg");
                    hashMap_photos.put("Ethical Hacking and Data Security workshop", "http://imgur.com/fDLsQiM.jpg");
                    hashMap_photos.put("Mobile Controlled Robotics", "http://imgur.com/8CcmYG6.jpg");

                    for(String name : hashMap_photos.keySet()){
                        TextSliderView textSliderView = new TextSliderView(getContext());
                        textSliderView
                                .description(name)
                                .image(hashMap_photos.get(name))
                                .setScaleType(BaseSliderView.ScaleType.Fit)
                                .setOnSliderClickListener(this);
                        textSliderView.bundle(new Bundle());
                        textSliderView.getBundle().putString("extra", name);
                        sliderLayout.addSlider(textSliderView);
                    }
                    sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
                    break;
                case "marksheets":
                    hashMap_photos.put("10th class", "http://i.imgur.com/Qq7R1XY.jpg");
                    hashMap_photos.put("12th Class", "http://imgur.com/Ngt4Unb.jpg");
                    hashMap_photos.put("B.Tech first semester", "http://imgur.com/LMnmqN5.jpg");
                    hashMap_photos.put("B.Tech second semester", "http://imgur.com/yp6ekAn.jpg");
                    hashMap_photos.put("B.Tech third semester", "http://imgur.com/2KUsYMZ.jpg");
                    hashMap_photos.put("B.Tech fourth semester", "http://imgur.com/6SBk2lC.jpg");
                    hashMap_photos.put("B.Tech fifth semester", "http://imgur.com/qckQIDu.jpg");
                    hashMap_photos.put("B.Tech sixth semester", "http://imgur.com/kAn2ted.jpg");
                    hashMap_photos.put("B.Tech seventh semester", "http://imgur.com/zFl9ICr.jpg");

                    for(String name : hashMap_photos.keySet()){
                        TextSliderView textSliderView = new TextSliderView(getContext());
                        textSliderView
                                .description(name)
                                .image(hashMap_photos.get(name))
                                .setScaleType(BaseSliderView.ScaleType.Fit)
                                .setOnSliderClickListener(this);
                        textSliderView.bundle(new Bundle());
                        textSliderView.getBundle().putString("extra", name);
                        sliderLayout.addSlider(textSliderView);
                    }
                    sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
                    break;
                case "social":
                    final String choose = getString(R.string.choose_an_app);
                    rootView.findViewById(R.id.linkedIn).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(Intent.createChooser(
                                    new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("https://www.linkedin.com/in/premsuman/")),
                                    choose)
                            );
                        }
                    });
                    rootView.findViewById(R.id.instagram).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(Intent.createChooser(
                                    new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("https://www.instagram.com/premroax/")),
                                    choose)
                            );
                        }
                    });
                    rootView.findViewById(R.id.facebook).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(Intent.createChooser(
                                    new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("https://www.facebook.com/premsuman8")),
                                    choose)
                            );
                        }
                    });
                    rootView.findViewById(R.id.whatsApp).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(Intent.createChooser(
                                    new Intent(Intent.ACTION_CALL_BUTTON,
                                            Uri.parse("tel:+918233477967")),
                                    choose)
                            );
                        }
                    });
                    rootView.findViewById(R.id.twitter).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(Intent.createChooser(
                                    new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("https://twitter.com/PremSuman8")),
                                    choose)
                            );
                        }
                    });
                    rootView.findViewById(R.id.pinterest).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(Intent.createChooser(
                                    new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("https://www.pinterest.com/premsuman/")),
                                    choose)
                            );
                        }
                    });
                    rootView.findViewById(R.id.quora).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(Intent.createChooser(
                                    new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("https://www.quora.com/profile/Prem-Suman")),
                                    choose)
                            );
                        }
                    });
                    rootView.findViewById(R.id.plus_google).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(Intent.createChooser(
                                    new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("https://plus.google.com/+PremSuman")),
                                    choose)
                            );
                        }
                    });

                    scrollView.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
        }
        return rootView;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getContext(), slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onStop() {
        sliderLayout.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onDetach() {
        scrollView.setVisibility(View.GONE);
        super.onDetach();
//        mListener = null;
    }

//    public interface OnFragmentInteractionListener {
//        void onFragmentInteraction(Uri uri);
//    }
}

