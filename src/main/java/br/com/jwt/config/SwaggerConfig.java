package br.com.jwt.config;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

	@Bean
	public Docket productApi(ServletContext servletContext) {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.jwt.resource"))
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/")
				.apiInfo(informationApi()
						.build());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/");
		
		registry.addResourceHandler("/**")
        .addResourceLocations("classpath:/static/");

	}

	private ApiInfoBuilder informationApi() {

		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

		apiInfoBuilder.title("API JWT");
		apiInfoBuilder.description("Api para geração de token para acessar a api. <br /> <br />  " +
				"<div class='opblock opblock-post' id='operations-Authorization'>                                                          " +
			    "    <div class='opblock-summary opblock-summary-post'>                                                                    " +
			    "        <span class='opblock-summary-method'>POST</span>                                                                  " +
			    "        <span class='opblock-summary-path'>                                                                               " +
			    "            <a class='nostyle' href='#'><span>/login</span></a>   							                               " +
			    "        </span>                                                                                                           " +
			    "        <div class='opblock-summary-description'>Método para geração de token.</div>                                      " +
			    "    </div>                                                                                                                " +
			    "    <div style='height: auto; border: none; margin: 0px; padding: 0px;'>                                                  " +
			    "        <div class='opblock-body'>                                                                                        " +
			    "            <div class='opblock-section'>                                                                                 " +
			    "                <div class='opblock-section-header'>                                                                      " +
			    "                    <div class='tab-header'><h4 class='opblock-title'>Parameters</h4>                                     " +
			    "                    </div>                                                                                                " +
			    "                </div>                                                                                                    " +
			    "                <div class='table-container'>                                                                             " +
			    "                    <table class='parameters'>                                                                            " +
			    "                        <thead>                                                                                           " +
			    "                            <tr>                                                                                          " +
			    "                                <th class='col col_header parameters-col_name'>Name</th>                                  " +
			    "                                <th class='col col_header parameters-col_description'>Description</th>                    " +
			    "                            </tr>                                                                                         " +
			    "                        </thead>                                                                                          " +
			    "                        <tbody>                                                                                           " +
			    "                            <tr class='parameters'>                                                                       " +
			    "                                <td class='col parameters-col_name'>                                                      " +
			    "                                    <div class='parameter__name required'>user                                  		   " +
			    "                                        <span style='color: red;'>&nbsp;*</span>                                          " +
			    "                                    </div>                                                                                " +
			    "                                    <div class='parameter__type'></div>                                                   " +
			    "                                    <div class='parameter__deprecated'></div>                                             " +
			    "                                    <div class='parameter__in'>(body)</div>                                               " +
			    "                                </td>                                                                                     " +
				"							    <td class='col parameters-col_description'>                                                " +
				"					                <div>                                                                                  " +
				"					                    <ul class='tab'>                                                                   " +
				"					                        <li class=\"tabitem active\">                                                    " +
				"					                            <a style='font-size: 12px;min-width: 90px;cursor: pointer;font-family: \"Titillium Web\", sans-serif;color: rgb(59, 65, 81);padding: 0px;' >Example Value</a>                  " +
				"					                        </li>                                                                          " +
				"					                        <li class=\"tabitem\">                                                           " +
				"					                            <a style='font-size: 12px;min-width: 90px;cursor: pointer;font-family: \"Titillium Web\", sans-serif;color: rgb(59, 65, 81);padding: 0px;'>Model</a>                            " +
				"					                        </li>                                                                          " +
				"					                    </ul>                                                                              " +
				"					                    <div>                                                                              " +
				"					                        <div >                                                       				   " +
				"					                            <div >                                                                     " +
				"					                                <pre >                                                                 " +
				"					                                    <div >{</div>                                                    " +
				"					                                    <span style='color: #555; font-weight: bold;'> </span>             " +
				"					                                    <div >\"username\" : \"string\",</div>       " +
				"					                                    <span style='color: #555; font-weight: bold;'> </span>             " +
				"					                                    <span style='color: #555;'></span>                         		   " +
				"					                                    <span style='color: #555; font-weight: bold;'></span>              " +
				"					                                    <div >\"password\" : \"string\"</div>        " +
//				"					                                    <span style='color: #555; font-weight: bold;'> </span>             " +
//				"					                                    <span style='color: #555;'></span>                         		   " +
				"					                                    <div style=''>}</div>                                            " +
				"					                                </pre>                                                                 " +
				"					                            </div>                                                                     " +
				"					                            <div class='body-param-options'>                                           " +
				"					                                <label for=''>                                                         " +
				"					                                    <span>Parameter content type</span>                                " +
				"					                                    <div class='content-type-wrapper body-param-content-type'>         " +
				"					                                        <select class='content-type'>                                  " +
				"					                                            <option value='application/json'>application/json</option> " +
				"					                                        </select>                                                      " +
				"					                                    </div>                                                             " +
				"					                                </label>                                                               " +
				"					                            </div>                                                                     " +
				"					                        </div>                                                                         " +
				"					                    </div>                                                                             " +
				"					                </div>                                                                                 " +
				"					            </td>                                                                                      " +
			    "                            </tr>                                                                                         " +
			    "                        </tbody>                                                                                          " +
			    "                    </table>                                                                                              " +
			    "                </div>                                                                                                    " +
			    "            </div>                                                                                                        " +
			    "            <div class='responses-wrapper'>                                                                               " +
			    "                <div class='opblock-section-header'><h4>Responses</h4><label><span>Response content type</span>           " +
			    "                    <div class='content-type-wrapper execute-content-type'>                                               " +
			    "                        <select class='content-type'><option value='*/*'>*/*</option></select>                            " +
			    "                    </div></label>                                                                                        " +
			    "                </div>                                                                                                    " +
			    "                <div class='responses-inner'>                                                                             " +
			    "                    <table class='responses-table'>                                                                       " +
			    "                        <thead>                                                                                           " +
			    "                            <tr class='responses-header'>                                                                 " +
			    "                                <td class='col col_header response-col_status'>Code</td>                                  " +
			    "                                <td class='col col_header response-col_description'>Description</td>                      " +
			    "                            </tr>                                                                                         " +
			    "                        </thead>                                                                                          " +
			    "                        <tbody>                                                                                           " +
			    "                            <tr class='response '>                                                                        " +
			    "                                <td class='col response-col_status'>200</td>                                              " +
			    "                                <td class='col response-col_description'>                                                 " +
			    "                                    <div class='response-col_description__inner'>                                         " +
			    "                                        <div class='markdown'>OK</div>                                                    " +
			    "                                    </div>                                                                                " +
			    "                                    <div>                                                                                 " +
			    "                                        <ul class='tab'>                                                                  " +
			    "                                            <li class='tabitem active'>                                                   " +
			    "                                                <a style='font-size: 12px;min-width: 90px;cursor: pointer;font-family: \"Titillium Web\", sans-serif;color: rgb(59, 65, 81);padding: 0px;' >Example Value</a>                 " +
			    "                                            </li>                                                                         " +
			    "                                            <li class='tabitem'>                                                          " +
			    "                                                <a style='font-size: 12px;min-width: 90px;cursor: pointer;font-family: \"Titillium Web\", sans-serif;color: rgb(59, 65, 81);padding: 0px;' >Model</a>                           " +
			    "                                            </li>                                                                         " +
			    "                                        </ul>                                                                             " +
			    "                                        <div class='highlight-code'>                                                      " +
			    "                                            <pre >                                              " +
			    "                                                <div class='markdown'>\"string\"</div>                                 " +
			    "                                            </pre>                                                                        " +
			    "                                        </div>                                                                            " +
			    "                                    </div>                                                                                " +
			    "                                </td>                                                                                     " +
			    "                            </tr>                                                                                         " +
			    "                        </tbody>                                                                                          " +
			    "                    </table>                                                                                              " +
			    "                </div>                                                                                                    " +
			    "            </div>                                                                                                        " +
			    "        </div>                                                                                                            " +
			    "    </div>                                                                                                                " +
			    "</div>                                                                                                                    " 
				
				);
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de uso: Propriedade de Victor Godoy.");
		apiInfoBuilder.license("Licença - Publica");
		apiInfoBuilder.licenseUrl("http://vgodoy.com.br");
		apiInfoBuilder.contact(contact());

		return apiInfoBuilder;

	}

	private Contact contact() {
		return new Contact(
				"Grupo de Desenvolvimento Victor Godoy",
				"http://vgodoy.com.br", 
				"vp.godoy@outlook.com"
				);
	}
	
	@Override 
	@SuppressWarnings("deprecation")
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) { 
	    configurer.favorPathExtension(false); 
	}
	
}
