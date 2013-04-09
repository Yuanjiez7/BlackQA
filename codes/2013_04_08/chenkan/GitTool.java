package org.qablack;

import java.io.File;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.revwalk.RevCommit;

public class GitTool {

	public static void main(String[] args) throws Throwable {

		String githubRepo = "https://github.com/chenkan/BlackQA.git";
		File localGitRepo = new File("/Users/chenkan/Documents/Workspace_JAVA/TDD/JGit/github_repo_11");
		// TODO �ж����·�����Ƿ��Ѵ���һ��Git��
		// TODO ��ʱʹ�þ���·��

		// Clone
		Git.cloneRepository().setURI(githubRepo).setDirectory(localGitRepo).call();

		// �򿪱��ظ���
		Git git = Git.open(localGitRepo);

		for (RevCommit revCommit : git.log().call()) {
			System.out.println(revCommit);
			System.out.println(revCommit.getShortMessage());
			System.out.println(revCommit.getCommitterIdent().getName() + " " + revCommit.getCommitterIdent().getEmailAddress() + "\n");
		}

	}

}