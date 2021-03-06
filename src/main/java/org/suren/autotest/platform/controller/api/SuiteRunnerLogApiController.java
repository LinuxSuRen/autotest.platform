/*
 * Copyright 2002-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.suren.autotest.platform.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.suren.autotest.platform.mapping.SuiteRunnerLogMapper;
import org.suren.autotest.platform.model.SuiteRunnerLog;

/**
 * 运行日志
 * @author suren
 * @date 2017年2月3日 下午6:54:30
 */
@RestController
@RequestMapping("/api/suite_runner_log")
public class SuiteRunnerLogApiController
{
	@Autowired
	private SuiteRunnerLogMapper suiteRunnerLogMapper;
	
	@RequestMapping(value = "/{runnerId}", method = RequestMethod.GET)
	public List<SuiteRunnerLog> list(@PathVariable String runnerId)
	{
		return suiteRunnerLogMapper.findByRunnerId(runnerId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public SuiteRunnerLog detail(@RequestParam String id)
	{
		return suiteRunnerLogMapper.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void del(@RequestParam String id)
	{
		suiteRunnerLogMapper.delById(id);
	}
}
