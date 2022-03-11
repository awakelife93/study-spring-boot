package proj.gateway.apigateway.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import proj.gateway.apigateway.common.error.APIResponseException;
import proj.gateway.apigateway.common.utils.HttpUtils;
import proj.gateway.apigateway.service.ContentsService;

@RestController("ContentsController")
public class ContentsController {

  @Resource(name = "ContentsService")
  private ContentsService contentsService;

  @GetMapping(value = "/findContentsCount")
  public String findContentsCount(HttpServletRequest request, HttpServletResponse response)
      throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = contentsService.findContentsCount(request);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @GetMapping(value = "/findContents")
  public String findContents(HttpServletRequest request, HttpServletResponse response) throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = contentsService.findContents(request);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @PostMapping(value = "/createContents")
  public String createContents(HttpServletRequest request, HttpServletResponse response, Map<String, Object> body)
      throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = contentsService.createContents(request, body);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @PatchMapping(value = "/updateContents")
  public String updateContents(HttpServletRequest request, HttpServletResponse response, Map<String, Object> body)
      throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = contentsService.updateContents(request, body);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }

  @DeleteMapping(value = "/removeContents")
  public String removeContents(HttpServletRequest request, HttpServletResponse response) throws APIResponseException {
    try {
      HashMap<String, Object> apiResponse = contentsService.removeContents(request);
      return HttpUtils.send(apiResponse, response);
    } catch (APIResponseException exception) {
      throw new APIResponseException(exception);
    }
  }
}