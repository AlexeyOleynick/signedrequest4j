package com.github.seratch.signedrequest4j.snippet;

import com.github.seratch.signedrequest4j.HttpResponse;
import com.github.seratch.signedrequest4j.OAuthConsumer;
import com.github.seratch.signedrequest4j.OAuthToken;
import com.github.seratch.signedrequest4j.SignedRequest;
import com.github.seratch.signedrequest4j.SignedRequestFactory;

import java.util.HashMap;
import java.util.Map;

public class ThreeLeggedSimplePOSTRequestSnippet {
	public static void main(String[] args) throws Exception {
		SignedRequest signedRequest = SignedRequestFactory
				.get3LeggedOAuthRequest("http://sp.example.com/",
						new OAuthConsumer("consumer_key", "consumer_secret"),
						new OAuthToken("access_token", "token_secret"));
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		requestParameters.put("something", "updated");
		HttpResponse response = signedRequest.doPost(
				"https://github.com/seratch/signedrequest4j",
				requestParameters, "UTF-8");
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
		System.out.println(response.getContent());
	}
}
