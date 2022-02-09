package kg.geektech.lvl5lesson1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import kg.geektech.lvl5lesson1.R;
import kg.geektech.lvl5lesson1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
    }
}