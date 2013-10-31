package GitCommitInterpreter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.egit.github.core.RepositoryCommit;

/**
 * Created with IntelliJ IDEA.
 * User: Alan Le
 * Date: 23/10/13
 * Time: 11:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommitInfo {

	private RepositoryCommit commit;
    private List<FileChanges> filesChangedList;

    public CommitInfo(RepositoryCommit commit) {
    	this.commit = commit;
        this.filesChangedList = new ArrayList<FileChanges>();
    }
    
    public String getSha() {
    	return commit.getSha();
    }
    
    public String getAuthorLogin() {
    	return commit.getAuthor().getLogin();
    }
    
    public String getCommitterLogin() {
    	return commit.getCommitter().getLogin();
    }

    public Date getAuthoredDate() {
    	return commit.getCommit().getAuthor().getDate();
    }
    
    public Date getCommittedDate() {
    	return commit.getCommit().getCommitter().getDate();
    }
    
    public int getAdditions() {
    	return commit.getStats().getAdditions();
    }
    
    public int getDeletions() {
    	return commit.getStats().getDeletions();
    }
    
    // Code for jgit below
    
    protected void addChangedFile(FileChanges changedFile) {
    	filesChangedList.add(changedFile);
    }

    public List<FileChanges> getFilesChanged() {
    	return filesChangedList;
    }
}
