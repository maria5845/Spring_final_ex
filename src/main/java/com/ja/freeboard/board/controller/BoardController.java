package com.ja.freeboard.board.controller;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.SimpleFormatter;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.ja.freeboard.board.service.BoardServiceImpl;
import com.ja.freeboard.vo.BoardVo;
import com.ja.freeboard.vo.MemberVo;
import com.ja.freeboard.vo.UploadFileVo;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardServiceImpl boardService;

	@RequestMapping("/main_page.do")
	public String mainPage(String search_word,Model model,
		
		@RequestParam(value="currPage",required = false,defaultValue = "1")int currPage) {
		
		List<Map<String,Object>> list =boardService.getBoardList(search_word,currPage);
		
		int totalCount = boardService.getBoardDataCount(search_word);

		
		int beginPage = ((currPage-1)/5)*5+1;
		
		int endPage = ((currPage-1)/5 + 1)*(5);
		
		if(endPage>((totalCount-1))/10+1) {
			endPage=((totalCount-1))/10+1;
		}
		model.addAttribute("beginPage",beginPage);
		
		model.addAttribute("endPage",endPage);
		
		model.addAttribute("totalCount",totalCount);
		
		model.addAttribute("datalist",list);
		
		model.addAttribute("currPage",currPage);
	
		return"board/main_page";
	}
	
	@RequestMapping("/write_content_page.do")
	public String writeContentPage() {
		
		return"board/write_content_page";
		
	}
	@RequestMapping("/write_content_process.do")
	public String writeContentProcess(MultipartFile [] upload_files,BoardVo boardVo ,HttpSession session) {
		
		String uploadRootFolderName = "C:/upload/";
		    
		Date today = new Date ();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		
		String todayFolder = df.format(today);
		
		String saveFolderName =  uploadRootFolderName + todayFolder ;
		
		File saveFolder = new File(saveFolderName);
		
		if(!saveFolder.exists()) {
		
			saveFolder.mkdirs();
		}
		
		List<UploadFileVo> fileVolist = new ArrayList<UploadFileVo>();
		
		
		for(MultipartFile file : upload_files) {
			 
		if(file.getSize() <=0) {
			continue;
		}
		//파일명 랜덤이름 짓기 ...(중복배제) 랜덤 + 시간 
	   	
		String saveFileName = UUID.randomUUID().toString();
	    
		String oriFileName = file.getOriginalFilename();
		
		saveFileName += "_" + System.currentTimeMillis();
	    
		saveFileName += oriFileName.substring(oriFileName.lastIndexOf("."));
	    
		String saveRealPath = saveFolderName + "/" + saveFileName ;
			
		try {
			file.transferTo(new File(saveRealPath));
		
		}catch (IOException e) {
		
			e.printStackTrace();
		}
		
		// DB를 위한 FileVo객체를 생성해주어야 한다. 
		
		UploadFileVo fileVo = new UploadFileVo();
		
		fileVo.setFile_link_path(todayFolder+"/"+ saveFileName);
		
		fileVo.setFile_real_path(saveRealPath);
       
		fileVolist.add(fileVo);	
        }
		//Vo 객체에는 필요한 정보들을 불러낼 수 있기 때문에 사용한다. 
		// session.getAttribute 는 오브젝트파일로 받기 때문에 MemberVo로 형변환 한다. 
		MemberVo memberVo=(MemberVo)session.getAttribute("sessionUser");
		
		boardVo.setMember_no(memberVo.getMember_no());
		
		boardService.writeContent(boardVo, fileVolist);
		
		return "redirect:./main_page.do";
	}
	@RequestMapping("/read_content_page.do")
	public String readContentPage(int board_no,Model model) {

      Map<String,Object> map =boardService.getBoard(board_no);
	  
      model.addAttribute("key",map);
		
	
		return "board/read_content_page";
	}
	@RequestMapping("/delete_content_process.do")
	public String deleteContent(int board_no) {
		
		boardService.deleteContent(board_no);
		return"redirect:/board/main_page.do";
	}
	
	@RequestMapping("/update_content_page.do")
	public String updateContentPage(int board_no,Model model) {
		
		model.addAttribute("update",boardService.getBoard(board_no));
		
		return"board/update_content_page";
	}
	
	@RequestMapping("/update_content_process.do")
	
	public String updateContentProcess(BoardVo boardVo) {
		
		boardService.updateContent(boardVo);
		
		
		return"redirect:/board/main_page.do";
	}
}
