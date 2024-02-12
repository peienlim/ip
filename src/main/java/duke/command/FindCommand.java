package duke.command;

import duke.DukeException;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

public class FindCommand extends Command {

    private String keyword;
    public FindCommand(String input, String keyword) {
        super(input);
        this.keyword = keyword;
    }

    @Override
    public String executeAndReply(Ui ui, TaskList tasks, Storage storage) throws DukeException {
        Task[] tasksToPrint = tasks.searchKeyWord(keyword);
        if (tasksToPrint[0] != null) {
            return ui.showTasksContainingKeyword(tasksToPrint);
        } else {
            throw new DukeException("UH OH! No tasks containing this keyword!");
        }
    }
}
