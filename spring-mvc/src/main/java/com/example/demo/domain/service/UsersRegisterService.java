package com.example.demo.domain.service;

import java.sql.Timestamp; //Dateクラスのサブクラス(Timestmp:日付と時刻の両方をミリ単位で表示）
import java.time.Instant; //Java8から導入された日時API（java.timeパッケージ）の一部、協定世界時での瞬間を表現するためのクラス

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.demo.domain.entity.Users;
import com.example.demo.domain.model.UserForm;
import com.example.demo.domain.repository.UsersRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsersRegisterService {

	@Autowired
	private UsersRepository usersRepository;
	

    public void register(final UserForm userForm) { //registerメソッド
        Users entity = new Users();
        entity.setName(userForm.getName());
        entity.setEmail(userForm.getEmail());
        entity.setAge(userForm.getAge());
        entity.setNote(userForm.getNote());
        
     //以下追加部分 
        Instant now = Instant.now(); //Instant.now()は現在の時間を取得するメソッド、日時操作や記録のタイムスタンプなどで使用
        entity.setRegisteredDate(Timestamp.from(now));
        entity.setUpdatedDate(Timestamp.from(now));
        // エンティティの登録日時と更新日時に現在の時刻を持つTimestmpインスタンスを作成
        
     
        usersRepository.save(entity);
    }
    
    public boolean isValid(UserForm userForm, BindingResult result) {
        if(usersRepository.existsByEmail(userForm.getEmail())) {
        	result.rejectValue("email",null,"既に登録されているE-Mailです。");
        return true;
        }
        return false;
    }

}