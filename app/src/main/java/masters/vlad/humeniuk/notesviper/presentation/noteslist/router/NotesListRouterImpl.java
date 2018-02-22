package masters.vlad.humeniuk.notesviper.presentation.noteslist.router;

import masters.vlad.humeniuk.notesviper.R;
import masters.vlad.humeniuk.notesviper.domain.entity.Note;
import masters.vlad.humeniuk.notesviper.presentation.base.BaseActivity;
import masters.vlad.humeniuk.notesviper.presentation.base.BaseRouter;
import masters.vlad.humeniuk.notesviper.presentation.createnote.CreateNoteActivity;
import masters.vlad.humeniuk.notesviper.presentation.editnote.EditNoteActivity;

public class NotesListRouterImpl extends BaseRouter implements NotesListRouter {

    public static final int REQUEST_CREATE_NOTE = 11;
    public static final int REQUEST_EDIT_NOTE = 12;

    public NotesListRouterImpl(BaseActivity activity) {
        super(activity, R.id.fragment_container);
    }

    @Override
    public void openNotesDetails(Note note) {
        startActivityForResult(EditNoteActivity.newIntent(getActivityContext(), note),
                REQUEST_EDIT_NOTE);
    }

    @Override
    public void openCreateNote() {
        startActivityForResult(CreateNoteActivity.newIntent(getActivityContext()),
                REQUEST_CREATE_NOTE);
    }
}
