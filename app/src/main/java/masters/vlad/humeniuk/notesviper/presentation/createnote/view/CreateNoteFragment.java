package masters.vlad.humeniuk.notesviper.presentation.createnote.view;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import javax.inject.Inject;

import butterknife.BindView;
import masters.vlad.humeniuk.notesviper.R;
import masters.vlad.humeniuk.notesviper.di.components.ActivityComponent;
import masters.vlad.humeniuk.notesviper.presentation.base.BaseFragment;
import masters.vlad.humeniuk.notesviper.presentation.createnote.presenter.CreateNotePresenter;

public class CreateNoteFragment extends BaseFragment implements CreateNoteView {

    @BindView(R.id.title)
    protected AppCompatEditText titleEditText;

    @BindView(R.id.description)
    protected AppCompatEditText descriptionEditText;

    @Inject
    protected CreateNotePresenter presenter;

    public static CreateNoteFragment newInstance() {

        Bundle args = new Bundle();

        CreateNoteFragment fragment = new CreateNoteFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_create_note;
    }

    @Override
    protected int getTitle() {
        return R.string.create_note_title;
    }

    @Override
    public void showEmptyFieldsError() {
        new AlertDialog.Builder(getBaseActivity())
                .setTitle(R.string.empty_note_fields_error)
                .setCancelable(true)
                .show();
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected boolean showOptionsMenu() {
        return true;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_save, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save: {
                presenter.onSaveNote(String.valueOf(titleEditText.getText()),
                        String.valueOf(titleEditText.getText()));
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }
}
