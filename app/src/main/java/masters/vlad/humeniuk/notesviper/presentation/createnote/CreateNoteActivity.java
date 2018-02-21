package masters.vlad.humeniuk.notesviper.presentation.createnote;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import masters.vlad.humeniuk.notesviper.R;
import masters.vlad.humeniuk.notesviper.di.components.ActivityComponent;
import masters.vlad.humeniuk.notesviper.presentation.base.BaseActivity;
import masters.vlad.humeniuk.notesviper.presentation.createnote.router.CreateNoteRouter;

public class CreateNoteActivity extends BaseActivity {

    @Inject
    protected CreateNoteRouter router;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, CreateNoteActivity.class);
        return intent;
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        router.showCreateNoteFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_single_fragment;
    }
}
