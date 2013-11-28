package RepositoryContent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
    private int additions;
    private int deletions;

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

    public Date getAuthoredDate() {
    	return commit.getCommit().getAuthor().getDate();
    }
    
    public Date getCommittedDate() {
    	return commit.getCommit().getCommitter().getDate();
    }
    
    public void setAdditions(int additions) {
    	this.additions = additions;
    }
    
    public int getAdditions() {
    	return additions;
    }
    
    public void setDeletions(int deletions) {
    	this.deletions = deletions;
    }
    
    public int getDeletions() {
    	return deletions;
    }
    
    public void addChangedFile(FileChanges changedFile) {
    	filesChangedList.add(changedFile);
    }

    public List<FileChanges> getFilesChanged() {
    	return filesChangedList;
    }
    
    public int getCommittedDateInSeconds() {
    	Date committedDate = this.getAuthoredDate();
    	Calendar calendar = GregorianCalendar.getInstance();
    	calendar.setTime(committedDate);
    	return calendar.get(Calendar.SECOND) + calendar.get(Calendar.MINUTE) * 60 + calendar.get(Calendar.HOUR_OF_DAY) * 3600;
    }
}
