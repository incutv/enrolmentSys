package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Notice;

@Mapper
//@CacheNamespace(flushInterval=60000)	//1분
public interface NoticeMapper {

	@Select("SELECT * FROM notice " +
			"WHERE start_date <= date_format(sysdate(), '%Y%m%d') " +
			"  AND end_date > date_format(sysdate(), '%Y%m%d') ")
	List<Notice> findAll();

	@Select("SELECT * FROM notice WHERE seq = #{seq} ")
	Notice findOne(int seq);


	@Insert("INSERT INTO notice (subject, contents, date, start_date, end_date, views, writer )   " +
			"VALUES ( #{subject}, #{contents}, #{date}, #{start_date}, #{end_date}, #{views}, #{writer} )")
	@Options(useGeneratedKeys=true, keyProperty="seq")
	void insert(Notice notice);

	@Update("UPDATE notice " +
			"SET subject = #{subject}, " +
			"	 contents = #{contents}, 	" +
			"	 date = #{date},  " +
			"	 start_date = #{start_date}, 	" +
			"	 end_date = #{end_date}, 	" +
			"	 writer = #{writer} 	" +
			"WHERE seq = #{seq} ")
	void update(Notice notice);

	@Delete("DELETE FROM notice WHERE seq = #{seq} ")
	void delete(int seq);


}
