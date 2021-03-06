
package cn.com.scrh.scrh_server.controller.business;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.scrh.scrh_server.commons.Constant;
import cn.com.scrh.scrh_server.commons.Tools;
import cn.com.scrh.scrh_server.controller.BaseController;
import cn.com.scrh.scrh_server.model.BusinessResultData;
import cn.com.scrh.scrh_server.model.balumas.BalumasRequest;
import cn.com.scrh.scrh_server.model.balumas.BalumasResp;
import cn.com.scrh.scrh_server.service.BalumasService;

/**
* @author karl E-mail:1834007615@qq.com
* @version 创建时间：2019年9月1日 下午4:11:38
* 类说明
*/

@Controller
public class BalumasController extends BaseController {
	
	private final static Logger logger = LoggerFactory.getLogger(BalumasController.class);
	
	@Autowired
	private BalumasService balumasService;
	
	@RequestMapping(value = "aaa", method = RequestMethod.GET)
	@ResponseBody
	public BusinessResultData findBalumasInfo(@Valid BalumasRequest request, BindingResult bindingResult){
		logger.info(Tools.getUUID());
        /* 校验请求数据 */
        checkValidation(bindingResult);
        /* 调用服务层 */
        BalumasResp balumasResp = balumasService.findBalumasInfo(request);
        BusinessResultData respBody = new BusinessResultData(Constant.SUCCESS, Constant.NOTIFY_SUCCESS, balumasResp);
		return respBody;
	}

}


