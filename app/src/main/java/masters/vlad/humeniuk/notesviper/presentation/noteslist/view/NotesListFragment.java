package masters.vlad.humeniuk.notesviper.presentation.noteslist.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import masters.vlad.humeniuk.notesviper.R;
import masters.vlad.humeniuk.notesviper.di.components.ActivityComponent;
import masters.vlad.humeniuk.notesviper.domain.entity.Note;
import masters.vlad.humeniuk.notesviper.presentation.base.BaseFragment;
import masters.vlad.humeniuk.notesviper.presentation.noteslist.presenter.NotesListPresenter;
import masters.vlad.humeniuk.notesviper.presentation.noteslist.view.list.NotesAdapter;

public class NotesListFragment extends BaseFragment implements NotesListView {

    @BindView(R.id.notes_list)
    protected RecyclerView notesListView;

    @Inject
    protected NotesListPresenter presenter;

    private NotesAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public static NotesListFragment newInstance() {

        Bundle args = new Bundle();

        NotesListFragment fragment = new NotesListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_notes_list;
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
        presenter.setView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        adapter = new NotesAdapter(getContext());
        layoutManager = new LinearLayoutManager(getContext());
        notesListView.setLayoutManager(layoutManager);
        notesListView.setAdapter(adapter);
        return view;
    }

    @Override
    protected void initViews() {
        super.initViews();
        presenter.loadNotes();
    }

    @Override
    public void showNotesList(List<Note> notes) {
        adapter.setData(notes);
    }

    @OnClick(R.id.add_note)
    protected void onAddNoteClick() {
        presenter.onCreateNote();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            presenter.loadNotes();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
