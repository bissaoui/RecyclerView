package ma.emsi.recyleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import ma.emsi.recyleview.adapter.StarAdapter;
import ma.emsi.recyleview.beans.Star;
import ma.emsi.recyleview.service.StarService;

public class ListActivity extends AppCompatActivity {
    private List<Star> stars;
    private RecyclerView recyclerView ,  recyclerView1;
    private StarAdapter starAdapter = null;
    StarService service;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                if (starAdapter != null){
                    starAdapter.getFilter().filter(newText);
                }
                return true;
            }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.share){
            String txt = "Stars";
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Stars")
                    .setText(txt)
                    .startChooser();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        stars = new ArrayList<>();
        service = StarService.getInstance();
        if(service.size()<=0)
        init();
        recyclerView = findViewById(R.id.recycle_view);
        recyclerView1 = findViewById(R.id.recycle_view1);
        //insérer le code
        starAdapter = new StarAdapter(this, service.findAll());
        recyclerView.setAdapter(starAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        recyclerView1.setAdapter(starAdapter);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

    }
    public void init(){
        service.create(new Star("Abdelbaset Taoussi", "https://instagram.fcmn1-1.fna.fbcdn.net/v/t51.2885-19/182537089_534255810917707_1293827072902916215_n.jpg?stp=dst-jpg_s150x150&_nc_ht=instagram.fcmn1-1.fna.fbcdn.net&_nc_cat=107&_nc_ohc=P4mFjk1g_xcAX-WLJbR&edm=ABfd0MgBAAAA&ccb=7-4&oh=00_AT8a5dB2Z2U2i_ER3evXV-ufzC3mBGibGd7qMVTELnPnzQ&oe=623C6884&_nc_sid=7bff83", 3.5f));
        service.create(new Star("Achraf Abolaoud", "https://instagram.fcmn1-2.fna.fbcdn.net/v/t51.2885-19/242329092_149535317371191_3552382480679253138_n.jpg?stp=dst-jpg_s320x320&_nc_ht=instagram.fcmn1-2.fna.fbcdn.net&_nc_cat=103&_nc_ohc=ePagW14G5RIAX-BvNL2&edm=ABfd0MgBAAAA&ccb=7-4&oh=00_AT9iHO46d6fQwBQ6sagQb69cYhLZRLHYV7Uu57uozAPTDw&oe=623B66A6&_nc_sid=7bff83", 3));
        service.create(new Star("Yassine Bissaoui",
                "https://instagram.fcmn1-1.fna.fbcdn.net/v/t51.2885-19/245529443_828234767871091_6058359811376932590_n.jpg?stp=dst-jpg_s320x320&_nc_ht=instagram.fcmn1-1.fna.fbcdn.net&_nc_cat=107&_nc_ohc=q4O4uS3dsBIAX_YTwo-&edm=ABfd0MgBAAAA&ccb=7-4&oh=00_AT_w7pcn3EInLwR6E10XMDpo0wisp65yCQy50W7BhES0cA&oe=623BC1C4&_nc_sid=7bff83", 5));
        service.create(new Star("souhail ElKhiyati", "https://instagram.fcmn1-1.fna.fbcdn.net/v/t51.2885-19/134474058_407901590360686_352473685065055000_n.jpg?stp=dst-jpg_s150x150&_nc_ht=instagram.fcmn1-1.fna.fbcdn.net&_nc_cat=110&_nc_ohc=MemRK92JHnsAX-h5bN_&edm=ABfd0MgBAAAA&ccb=7-4&oh=00_AT-Z-vFDAlnKqH_Q_jl4bM7Av8r7Cn9_R-82oXFV_stfXg&oe=623C230F&_nc_sid=7bff83", 1));
        service.create(new Star("Lina Al Mahi ", "https://instagram.fcmn1-1.fna.fbcdn.net/v/t51.2885-19/274790974_2532653610202598_204157015803835756_n.jpg?stp=dst-jpg_s150x150&_nc_ht=instagram.fcmn1-1.fna.fbcdn.net&_nc_cat=102&_nc_ohc=Qd_ss3dMEZ8AX9-773P&edm=ABfd0MgBAAAA&ccb=7-4&oh=00_AT_oJqZ8Gn_uGcsLOwp0pSIQ1d3m-FYgouGQyNbxswUojA&oe=623BBD63&_nc_sid=7bff83", 5));
        service.create(new Star("Youssra Rahili", "https://instagram.fcmn1-2.fna.fbcdn.net/v/t51.2885-19/275768710_652741522658352_3414092291160253279_n.jpg?stp=dst-jpg_s150x150&_nc_ht=instagram.fcmn1-2.fna.fbcdn.net&_nc_cat=100&_nc_ohc=ujnjY4vl-9EAX_zAa-j&edm=ABfd0MgBAAAA&ccb=7-4&oh=00_AT_3OyHxqB7m6NCyV0hOM2-rBZo0MmZonKaDO4P1fI3pvg&oe=623BEDC7&_nc_sid=7bff83", 1));

    }
}