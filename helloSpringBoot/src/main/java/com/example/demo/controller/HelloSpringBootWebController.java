package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloSpringBootWebController {
	 @RequestMapping(value="/", method=RequestMethod.GET)
	 //リクエストマッピング：アクセスするアドレスと実行する処理（indexメソッド）の結びつきを設定
	 //@RequestMappingアノテーション の引数に、value="/" と method=RequestMethod.GET を指定
	 //'value'属性は http://○○/ にアクセスした時に、このメソッドが実行
	 //'method'属性は、GETメソッドでのアクセス時、POSTメソッドでのアクセス時なのかを指定
	    public String index() { //indexメソッド→http://○○/にアクセスされると、index.htmlに遷移される
	        return "index";
	        //return文で画面に表示したいhtmlファイル名を指定
	        //(今回はindex.htmlのためindexで返している）
	    }

	    @RequestMapping(value="/result", method=RequestMethod.POST)
	    public String send(@RequestParam("inputvalue")String inputvalue, Model model) { 
	    	//sendメソッドの引数に @RequestParamアノテーションが設定→リクエストに渡されたパラメータの値を示す
	    	//フォームから送られた値がinputvalue(引数）に設定される
	    	//index.htmlの入力フィールドに書かれた値がString　inputvalueに渡される
	        model.addAttribute("message", inputvalue); //addAttributeメソッド→modelに値を保管するもの
	        //第1引数に名前、第2引数に保管するオブジェクトを指定(今回は"message" という名前で inputvalue (ビューで入力された値) が保管される)
	        //addAttributeメソッドでModelに保管された値は式言語を使って出力
	        return "result";
	    }
}
