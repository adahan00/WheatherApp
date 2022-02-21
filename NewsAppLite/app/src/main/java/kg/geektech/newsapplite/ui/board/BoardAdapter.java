package kg.geektech.newsapplite.ui.board;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import kg.geektech.newsapplite.R;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {


    private String[] titles = new String[]{"салам", "привет", "hello"};
    private String[] desc = new String[]{"кандай", "как дела", "how are you"};
    private int [] img1 = new int[] {R.drawable.lx570,R.drawable.cjd,R.drawable.cls63amg };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_board, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle;
        private TextView description;
        private Button button;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            description = itemView.findViewById(R.id.textDesc);
            button = itemView.findViewById(R.id.start);
            imageView = itemView.findViewById(R.id.imageView);
        }

        public void bind(int position) {
            textTitle.setText(titles[position]);
            description.setText(desc[position]);
            imageView.setImageResource(img1[position]);


            if (position == 2) {
                button.setVisibility(View.VISIBLE);
            } else button.setVisibility(View.INVISIBLE);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavController navController = Navigation.findNavController((Activity) view.getContext(), R.id.nav_host_fragment_activity_main);
                    navController.navigateUp();
                }
            });
        }
    }
}

