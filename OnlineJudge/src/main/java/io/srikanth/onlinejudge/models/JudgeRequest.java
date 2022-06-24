package io.srikanth.onlinejudge.models;

public class JudgeRequest {

	private String code;
	private Language compiler;
	private String contest_id;
	private String problem_index;
	private int testCases;
	private double timeLimit;

	public String getProblem_index() {
		return problem_index;
	}

	public void setProblem_index(String problem_index) {
		this.problem_index = problem_index;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Language getCompiler() {
		return compiler;
	}

	public void setCompiler(Language compiler) {
		this.compiler = compiler;
	}

	public String getContest_id() {
		return contest_id;
	}

	public void setContest_id(String contest_id) {
		this.contest_id = contest_id;
	}

	public int getTestCases() {
		return testCases;
	}

	public void setTestCases(int testCases) {
		this.testCases = testCases;
	}

	public double getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(double timeLimit) {
		this.timeLimit = timeLimit;
	}

	@Override
	public String toString() {
		return "RunRequest [code=" + code + ", compiler=" + compiler + ", contest_id=" + contest_id + ", problem_index="
				+ problem_index + ", testCases=" + testCases + ", timeLimit=" + timeLimit + "]";
	}

}