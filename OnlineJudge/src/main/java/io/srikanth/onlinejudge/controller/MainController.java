package io.srikanth.onlinejudge.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.srikanth.onlinejudge.models.RunRequest;
import io.srikanth.onlinejudge.models.RunnerResponse;
import io.srikanth.onlinejudge.service.CodeRunner;

@RestController
public class MainController {
	final Logger logger = LogManager.getLogger(MainController.class);

	@Autowired
	private CodeRunner runner;

	@PostMapping("/run")
	public RunnerResponse runCode(@RequestBody RunRequest request) throws IOException, InterruptedException {
		logger.info("Running the code");
		RunnerResponse response = runner.initiateRequest(request);
		runner.run(request, response);
		return response;
	}
}
