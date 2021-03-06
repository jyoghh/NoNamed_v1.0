var token = $("input[name='_csrf']").val();
var header = "X-CSRF-TOKEN";


var obj_types = ['OS','DBMS','WEB','Network','SH','SM','privacy','backup','WAS'];
var objects = [{
    'OS' : 'OS',
    'DBMS' : 'DBMS',
    'WEB' : 'WEB',
    'Network' : 'Network',
    'SH' : '보안장비',
    'SM' : '관리보안',
    'privacy' : '개인정보',
    'backup' : '백업장비',
    'WAS' : 'WAS',
}];

var getConfDatatableURL;
getConfDatatableURL = 'getConfDatatable.do';


//
// **********************************************************************************************
// 데이터테이블 영역
//************************************************************************************************
//

var lang_kor = {
    "decimal" : "",
    "emptyTable" : "데이터가 없습니다.",
    "info" : "_START_ - _END_ (총 _TOTAL_ 건)",
    "infoEmpty" : "0건",
    "infoFiltered" : "(전체 _MAX_ 명 중 검색결과)",
    "infoPostFix" : "",
    "thousands" : ",",
    "lengthMenu" : "_MENU_ 개씩 보기",
    "loadingRecords" : "로딩중...",
    "processing" : "처리중...",
    "search" : "검색 : ",
    "zeroRecords" : "검색된 데이터가 없습니다.",
    "paginate" : {
        "first" : "첫 페이지",
        "last" : "마지막 페이지",
        "next" : "다음",
        "previous" : "이전"
    },
    "aria" : {
        "sortAscending" : " :  오름차순 정렬",
        "sortDescending" : " :  내림차순 정렬"
    }
};

var buttons = [
    {
        extend: 'excel',
        className: 'btn-success'
    },
    {
        extend: 'copy',
        className: 'btn-primary'
    },
    {
        extend: 'csv',
        className: 'btn-warning'
    },
    {
        extend: 'pdf',
        className: 'btn-danger'
    },
];
//
//
// **********************************************************************************************
// 일반 영역
//************************************************************************************************
//
//
// 팝업 노출 이벤트
function layer_open(el){
  var temp = $('#' + el);

  $('.layer').fadeIn();	//'bg' 클래스가 존재하면 레이어가 나타나고 배경은 dimmed 된다.
  temp.fadeIn();

  // 화면의 중앙에 레이어를 띄운다.
  if (temp.outerHeight() < $(document).height() ) temp.css('margin-top', '-'+temp.outerHeight()/2+'px');
  else temp.css('top', '0px');
  if (temp.outerWidth() < $(document).width() ) temp.css('margin-left', '-'+temp.outerWidth()/2+'px');
  else temp.css('left', '0px');
  temp.show();

  temp.find('a.cbtn').click(function(e){
      e.preventDefault();
      $('.layer').fadeOut(); //'bg' 클래스가 존재하면 레이어를 사라지게 한다.
      temp.fadeOut().hide();
  });

  $('.layer .bg').click(function(e){	//배경을 클릭하면 레이어를 사라지게 하는 이벤트 핸들러
      e.preventDefault();
      $('.layer').fadeOut();
      $('.pop-layer').hide();
  });
}

// string to array
 function strToarr(str) {
    var res = [];
    res = str.split(", ");
    return res;
}

// 숫자에 천단위 콤마 반환
function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

// url get parameter 가져오기
function geturlparam (name) {
  var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
  if (results==null){
    return null;
  } else{
    return results[1] || 0;
  }
}

// 점검 igid, cgid 로
function getTotalInspect(igid, cgid) {
    var res = [];
    $.ajax({
        type: "POST",
        url: "getInspectGroup.do",
        async: false,
        data: {
            'igid': igid
        },
        success: function (data) {
            res['oids'] = data.data.objects;
        }
    });
    $.ajax({
        type: "POST",
        url: "getConfluenceGroup.do",
        async: false,
        data: {
            'cgid': cgid
        },
        success: function (data) {
            res['cids'] = data.data.confs;
        }
    });
    var total = strToarr(res['oids']).length * strToarr(res['cids']).length;
    return total;
}

// 점검 iid 로 점검진행률 가져오기
function getInspectDoneCount(iid) {
    var inspect_done = "";
    $.ajax({
        type : "POST",
        url : "getInspectProgress.do",
        async : false,
        data : {
          'iid' : iid
        },
        success: function(data){
          inspect_done = data.pop();
        }
    });
    return inspect_done;
}

// 파일 타입 체크
function checkFileType(filePath) {
    var fileFormat = filePath.split(".");
    if (fileFormat.indexOf("xlsx") > -1) {
        return true;
    } else {
        return false;
    }
}


