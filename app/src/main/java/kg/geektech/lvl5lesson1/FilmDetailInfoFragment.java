package kg.geektech.lvl5lesson1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import kg.geektech.lvl5lesson1.databinding.FragmentFilmDetailInfoBinding;
import kg.geektech.lvl5lesson1.databinding.FragmentFilmsBinding;


public class FilmDetailInfoFragment extends Fragment {
private FragmentFilmDetailInfoBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFilmDetailInfoBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String getPhoto = requireArguments().getString("Film");
    Glide.with(binding.imageFilm).load(getPhoto).circleCrop().into(binding.imageFilm);
        String getDirectorName = requireArguments().getString("Director");
        binding.tvDirectory.setText(getDirectorName);
        String getProdName = requireArguments().getString("Prod");
        binding.tvProd.setText(getProdName);
        String getReleaseDate = requireArguments().getString("RelDate");
        binding.tvReleaseDate.setText(getReleaseDate);
        String getTitle = requireArguments().getString("Title");
        binding.tvTittle.setText(getTitle);

    }
}