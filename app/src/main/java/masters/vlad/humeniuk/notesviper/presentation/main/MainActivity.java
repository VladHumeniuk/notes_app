package masters.vlad.humeniuk.notesviper.presentation.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import butterknife.BindView;
import masters.vlad.humeniuk.notesviper.R;
import masters.vlad.humeniuk.notesviper.di.components.ActivityComponent;
import masters.vlad.humeniuk.notesviper.presentation.base.BaseActivity;
import masters.vlad.humeniuk.notesviper.presentation.main.presenter.MainPresenter;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_navigation)
    protected BottomNavigationView bottomNavigationView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Inject
    protected MainPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.init();
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void initViews() {
        super.initViews();
        bottomNavigationView.setOnNavigationItemSelectedListener(listener);
        bottomNavigationView.setSelectedItemId(R.id.action_notes);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        presenter.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            item -> {
                switch (item.getItemId()) {
                    case R.id.action_notes: {
                        presenter.onNotesListClick();
                        return true;
                    }
                    case R.id.action_categories: {
                        presenter.onCategoriesClick();
                        return true;
                    }
                    default: {
                        return false;
                    }
                }
            };
}
