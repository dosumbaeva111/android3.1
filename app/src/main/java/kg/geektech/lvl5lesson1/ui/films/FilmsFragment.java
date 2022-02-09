package kg.geektech.lvl5lesson1.ui.films;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import kg.geektech.lvl5lesson1.App;
import kg.geektech.lvl5lesson1.R;
import kg.geektech.lvl5lesson1.data.models.Film;
import kg.geektech.lvl5lesson1.databinding.FragmentFilmsBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsFragment extends Fragment implements OnItemClick {

    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;

    public FilmsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        adapter = new FilmsAdapter(this);
        binding = FragmentFilmsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recycler.setAdapter(adapter);
        fetchFilms();
    }

    private void fetchFilms() {
        App.api.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setFilms(response.body());
                } else {
                    Log.e("Tag", "onResponse:" + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                Log.e("Tag", "onResponse:" + t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onClick(Film film, String id) {
        App.api.getFilmById(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() != null) {

                    NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                    Bundle bundle = new Bundle();
                    bundle.putString("Film", film.getMovieBanner());
                    bundle.putString("Director", film.getDirector());
                    bundle.putString("Prod", film.getProducer());
                    bundle.putString("RelDate", film.getReleaseDate());
                    bundle.putString("Title", film.getTitle());
                    navController.navigate(R.id.filmDetailInfoFragment, bundle);
                    
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                Log.e("Tag", "onResponse:" + t.getLocalizedMessage());
            }
        });



    }
}