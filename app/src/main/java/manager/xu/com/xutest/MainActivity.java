package manager.xu.com.xutest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.beam.bijection.RequiresPresenter;

import manager.xu.com.xutest.base.BaseActivity;

@RequiresPresenter(MainPresenter.class)
public class MainActivity extends BaseActivity<MainPresenter> {
//test
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.setLayoutManager(layoutManager);
        ImgAdapter adapter = new ImgAdapter();
        recyclerView.setAdapter(adapter);

    }

    class ImgAdapter extends RecyclerView.Adapter<ImgAdapter.ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_img,null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            ViewGroup.LayoutParams lp = holder.imageView.getLayoutParams();
        }

        @Override
        public int getItemCount() {
            return 10;
        }
        class ViewHolder extends RecyclerView.ViewHolder{
            public ImageView imageView;
            public ViewHolder(View itemView) {
                super(itemView);
                imageView = (ImageView) itemView.findViewById(R.id.img1);

            }
        }
    }
}
