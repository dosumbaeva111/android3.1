package kg.geektech.lvl5lesson1.ui.films;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import kg.geektech.lvl5lesson1.data.models.Film;
import kg.geektech.lvl5lesson1.databinding.ItemFilmBinding;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.Viewholder> {
    private List<Film> films = new ArrayList<>();
    private OnItemClick listener;

    public FilmsAdapter(OnItemClick listener) {
        this.listener = listener;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    public void getId(int position) {
        films.get(position);
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmBinding binding = ItemFilmBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.onBind(films.get(position));

    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private ItemFilmBinding binding;

        public Viewholder(@NonNull ItemFilmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Film film) {
            binding.title.setText(film.getTitle());
            binding.description.setText(film.getDescription());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(film, film.getId());
                }
            });
        }
    }
}
