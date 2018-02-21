package masters.vlad.humeniuk.notesviper.presentation.noteslist.router;

import masters.vlad.humeniuk.notesviper.R;
import masters.vlad.humeniuk.notesviper.domain.entity.Note;
import masters.vlad.humeniuk.notesviper.presentation.base.BaseActivity;
import masters.vlad.humeniuk.notesviper.presentation.base.BaseRouter;
import masters.vlad.humeniuk.notesviper.presentation.createnote.CreateNoteActivity;

public class NotesListRouterImpl extends BaseRouter implements NotesListRouter {

    public static final int REQUEST_CREATE_NOTE = 1;

    public NotesListRouterImpl(BaseActivity activity) {
        super(activity, R.id.fragment_container);
    }

    @Override
    public void openNotesDetails(Note note) {
        //TODO
    }

    @Override
    public void openCreateNote() {
        startActivityForResult(CreateNoteActivity.newIntent(getActivityContext()), REQUEST_CREATE_NOTE);
    }
}
