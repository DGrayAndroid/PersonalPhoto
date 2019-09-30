package dalton.gray.personalphoto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Friend[] friends = {
            new Friend("Cassandra", R.drawable.cassandra),
            new Friend("Jennifer", R.drawable.jennifer),
            new Friend("Chris", R.drawable.chris),
            new Friend("Kayla", R.drawable.kayla),
            new Friend("Lynn", R.drawable.lynn),
            new Friend("Phillip", R.drawable.phillip),
            new Friend("Scott", R.drawable.scott),
            new Friend("Troy", R.drawable.troy)
        };

        ImageView pic;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            GridView gridView = (GridView)findViewById(R.id.gridView);
            final ImageView imgLarge = (ImageView)findViewById(R.id.imgLarge);
            gridView.setAdapter(new ImageAdapter(this));
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                Toast.makeText(MainActivity.this, "First Name of Friend: " + friends[index].getFirstName(), Toast.LENGTH_SHORT).show();
                imgLarge.setImageResource(friends[index].getPhotoResource());
            }
        });
    }

    private class ImageAdapter extends BaseAdapter {
        private Context context;

        public ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return friends.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int index, View view, ViewGroup viewGroup) {
            pic = new ImageView(context);
            pic.setImageResource(friends[index].getPhotoResource());
            pic.setScaleType(ImageView.ScaleType.FIT_CENTER);
            pic.setLayoutParams(new GridView.LayoutParams(500, 500));
            return pic;
        }
    }
}
