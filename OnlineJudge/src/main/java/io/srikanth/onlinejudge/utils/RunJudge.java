package io.srikanth.onlinejudge.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

import io.srikanth.onlinejudge.models.Language;
import io.srikanth.onlinejudge.models.Verdict;

public class RunJudge implements Runnable {
	private Language language;
	private String contest_id;
	private String problem_index;
	private int test_cases;
	private String token;
	private Verdict verdict;
	private String verdict_note;
	private String file_name;
	private String command;

	public RunJudge(Builder builder) {
		setContest_id(builder.contest_id);
		setProblem_index(builder.problem_index);
		setTest_cases(builder.test_cases);
		setToken(UUID.randomUUID().toString());
		setFile_name(file_name);
	}

	static class Builder {
		Language language;
		String contest_id;
		String problem_index;
		String file_name;
		int test_cases;

		public Builder(String contest_id, String problem_index) {
			this.contest_id = contest_id;
			this.problem_index = problem_index;
		}

		public void language(String language) {
			this.language = Language.valueOf(language);
		}

		public void test_cases(int test_cases) {
			this.test_cases = test_cases;
		}

		public void file_name(String file_name) {
			this.file_name = file_name;
		}
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getContest_id() {
		return contest_id;
	}

	public void setContest_id(String contest_id) {
		this.contest_id = contest_id;
	}

	public String getProblem_index() {
		return problem_index;
	}

	public void setProblem_index(String problem_index) {
		this.problem_index = problem_index;
	}

	public int getTest_cases() {
		return test_cases;
	}

	public void setTest_cases(int test_cases) {
		this.test_cases = test_cases;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Verdict getVerdict() {
		return verdict;
	}

	public void setVerdict(String verdict) {
		this.verdict = Verdict.valueOf(verdict);
	}

	public String getVerdict_note() {
		return verdict_note;
	}

	public void setVerdict_note(String verdict_note) {
		this.verdict_note = verdict_note;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	@Override
	public void run() {
		// TODO Code To run the shell script
		ProcessBuilder builder = new ProcessBuilder(this.command);
		try {
			Process program = builder.start();
			StringBuilder verdict = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(program.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				verdict.append(line);
			}
			this.verdict_note = verdict.toString();
			if (verdict.toString().contains("wrong answer")) {
				setVerdict("WRONG_ANSWER");
			} else if (verdict.toString().contains("accepted")) {
				setVerdict("ACCEPTED");
			}
			else {
				setVerdict("PLAGRIZED");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
