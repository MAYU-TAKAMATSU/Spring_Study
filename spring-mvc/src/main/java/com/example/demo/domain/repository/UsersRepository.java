package com.example.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
//
	//JpaRepositoryを継承
	//第1引数：このリポジトリが対象とするエンティティ（クラス）
	//第2引数：対象エンティティで@Idが指定されているプロパティのクラス(Usersの場合、id→Integer)

//リポジトリ(Repository):エンティティに対する処理を自動生成する仕組みを実現する

//指定したE-Mailが存在するかチェックするメソッド
boolean existsByEmail(String emails); 

}
