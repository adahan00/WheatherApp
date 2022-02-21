package kg.geektech.newsapplite.ui.board;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import kg.geektech.newsapplite.R;


public class BoardFragment extends Fragment {

    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_board, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BoardAdapter adapter = new BoardAdapter();
        ViewPager2 viewPager = view.findViewById(R.id.viewPager);
        button =  view.findViewById(R.id.skip);

        SpringDotsIndicator  springDotsIndicator = view.findViewById(R.id.spring_dots_indicator);
        viewPager.setAdapter(adapter);

        springDotsIndicator.setViewPager2(viewPager);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);

                if (position == 2){
                    button.setVisibility(View.INVISIBLE);

                }else button.setVisibility(View.VISIBLE);
            }
        });

        button.setOnClickListener(view1 -> {
            NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
            navController.navigateUp();

                   });

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().finish();
            }
        });
    }
}