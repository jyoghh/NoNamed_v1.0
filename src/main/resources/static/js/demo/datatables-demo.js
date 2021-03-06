// Call the dataTables jQuery plugin
$(document).ready(function() {
  var dataSet = [
        [ '<input type="checkbox" class="checked">', "결재반려", "점검결과 미등록", "마블/개발팀", "권리보장제도운영실태점검", "권리보장제도운영분야", "분기별","마블 권리보장용","마블/개발팀/01","김현동","미확정","수동입력" ],
    ];

  var InspectDonelist_dataSet = [
            [
                '점검완료',
                '<span>2020년 정보보안 테스트</span><br><span>조치계획 수립기간 : 2020.04.01</span>',
                '조치계획 등록률 1.3%<br><div class="progress progress-sm mr-2"><div class="progress-bar bg-info" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div></div>',
                '0',
                '0',
                '9',
                '0',
                '2',
                '0',
                '0'
            ],
            ["점검완료", "2020년 01월 정보보안 월간점검", "조치계획 등록률 1.3%", "0", "0", "9", "0", "2", "0", "0"],
            ["점검완료", "2020년 01월 정보보안 월간점검", "조치계획 등록률 1.3%", "0", "0", "9", "0", "2", "0", "0"],
            ["점검완료", "2020년 01월 정보보안 월간점검", "조치계획 등록률 1.3%", "0", "0", "9", "0", "2", "0", "0"],
            ["점검완료", "2020년 01월 정보보안 월간점검", "조치계획 등록률 1.3%", "0", "0", "9", "0", "2", "0", "0"],
  ];

  var InspectDonelistReport_dataSet = [
      [
          '1',
          '점검완료',
          '내려받기',
          '보기',
          '조치계획 진행중',
          '권리보장제도운영실태점검',
          '아아아',
          '분기 별',
      ]
  ];

  var InspectDonelistReportDetail_dataSet = [
      [
          '마케팅 연락중지 청구권',
          '<a href="#" class="detail-popup" id="desc_popup"><span class="text">동의 철회 청구시스템 또는 절차 마련여부, 권리내용 및 행시령법 고지 여부</span></a>',
          'R/A',
          '2020-07-15',
          '티켓이관',
          '<a href="#" class="btn btn-info btn-icon-split" id="detail_popup"><span class="text">상세보기</span></a>',
      ]
  ];

  var MeasureRegister_dataSet = [
            [
                '등록완료',
                '<span>2020년 정보보안 테스트</span><br><span>점검기간 : 2020.04.01</span>',
                '점검진행률 : 1.3%<br><div class="progress progress-sm mr-2"><div class="progress-bar bg-info" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div></div>',
                '0',
                '0',
                '9',
                '0',
                '2',
                '0',
                '0'
            ],
            [
                '진행중',
                '<span>2020년 정보보안 테스트</span><br><span>점검기간 : 2020.04.01</span>',
                '점검진행률 : 1.3%<br><div class="progress progress-sm mr-2"><div class="progress-bar bg-info" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div></div>',
                '0',
                '0',
                '9',
                '0',
                '2',
                '0',
                '0'
            ],
            ["점검완료", "2020년 01월 정보보안 월간점검", "조치계획 등록률 1.3%", "0", "0", "9", "0", "2", "0", "0"],
            ["점검완료", "2020년 01월 정보보안 월간점검", "조치계획 등록률 1.3%", "0", "0", "9", "0", "2", "0", "0"],
  ];

  // var MeasureDetail_dataSet = [
  //     [
  //         'A-P01-0001',
  //         '상시 출입자에 대한 책임자 승인 및 출입자 관리기록부 보관 여부',
  //         'VH',
  //         '미준수',
  //         '조치계획'
  //     ],
  //     [
  //         'A-P01-0002',
  //         '무인감시카메라 또는 출입자동기록시스템 등의 정상 작동 여부',
  //         'VH',
  //         '미준수',
  //         '<a href="#" class="reg-btn">미등록</a>'
  //     ],
  // ];

  var MeasureLiveList_dataSet = [
            [
                '점검완료',
                '<span>2020년 정보보안 테스트</span><br><span>조치계획 수립기간 : 2020.04.01</span>',
                '조치계획 등록률 1.3%<br><div class="progress progress-sm mr-2"><div class="progress-bar bg-info" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div></div>',
                '0',
                '0',
                '9',
                '0',
                '2',
                '0',
                '0'
            ],
            ["점검완료", "2020년 01월 정보보안 월간점검", "조치계획 등록률 1.3%", "0", "0", "9", "0", "2", "0", "0"],
            ["점검완료", "2020년 01월 정보보안 월간점검", "조치계획 등록률 1.3%", "0", "0", "9", "0", "2", "0", "0"],
            ["점검완료", "2020년 01월 정보보안 월간점검", "조치계획 등록률 1.3%", "0", "0", "9", "0", "2", "0", "0"],
            ["점검완료", "2020년 01월 정보보안 월간점검", "조치계획 등록률 1.3%", "0", "0", "9", "0", "2", "0", "0"],
  ];

  var MeasureLiveListDetail_dataSet = [
      [
          '<input type="checkbox" class="checked">',
          'R/A',
          '처리대기중',
          '<a href="#" class="detail-btn">보기</a>',
          '정보보호팀 보안운영지원/전태린',
          '마블시스템그룹',
          '권리보장제도운영실태점검',
          '권리보장제도운영실태',
          ' ',

      ]
  ];

  var MeasureTicketList_dataSet = [
            [
                '접수대기',
                '<span>T20-0344728</span><br><span>2020 정보보안 테스트</span>',
                '티켓처리율 등록률 50%<br><div class="progress progress-sm mr-2"><div class="progress-bar bg-info" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div></div>',
                '0',
                '0',
                '9',
                '0',
                '2',
                '0',
                '0'
            ],
            [
                '접수대기',
                '<span>T20-0344728</span><br><span>2020 정보보안 테스트</span>',
                '티켓처리율 등록률 50%<br><div class="progress progress-sm mr-2"><div class="progress-bar bg-info" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div></div>',
                '0',
                '0',
                '9',
                '0',
                '2',
                '0',
                '0'
            ],
  ];

  var ReportList_dataSet = [
      [
          '노바소프트그룹/ICT본부',
          'hostnm_1000',
          '16.112.22.22',
          'WINDOWS',
          'windows2012',
          '노바_1000_windows2012',
          '노바소프트그룹/인프라운영팀 시스템운영',
          '윤서연',
          '노바소프트그룹/인프라운영팀 시스템운영',
          '전지율',
          '점검대기중',
          ' ',
          '점검 이력이 없습니다.',
      ],
      [
          '노바소프트그룹/ICT본부',
          'hostnm_1000',
          '16.112.22.22',
          'WINDOWS',
          'windows2012',
          '노바_1000_windows2012',
          '노바소프트그룹/인프라운영팀 시스템운영',
          '윤서연',
          '노바소프트그룹/인프라운영팀 시스템운영',
          '전지율',
          '점검대기중',
          ' ',
          '점검 이력이 없습니다.',
      ],
      [
          '노바소프트그룹/ICT본부',
          'hostnm_1000',
          '16.112.22.22',
          'WINDOWS',
          'windows2012',
          '노바_1000_windows2012',
          '노바소프트그룹/인프라운영팀 시스템운영',
          '윤서연',
          '노바소프트그룹/인프라운영팀 시스템운영',
          '전지율',
          '점검완료',
          ' ',
          '점검 이력이 없습니다.',
      ],
      [
          '노바소프트그룹/ICT본부',
          'hostnm_1000',
          '16.112.22.22',
          'WINDOWS',
          'windows2012',
          '노바_1000_windows2012',
          '노바소프트그룹/인프라운영팀 시스템운영',
          '윤서연',
          '노바소프트그룹/인프라운영팀 시스템운영',
          '전지율',
          '점검대기중',
          ' ',
          '점검 이력이 없습니다.',
      ],
      [
          '노바소프트그룹/ICT본부',
          'hostnm_1000',
          '16.112.22.22',
          'WINDOWS',
          'windows2012',
          '노바_1000_windows2012',
          '노바소프트그룹/인프라운영팀 시스템운영',
          '윤서연',
          '노바소프트그룹/인프라운영팀 시스템운영',
          '전지율',
          '점검대기중',
          ' ',
          '점검 이력이 없습니다.',
      ],
      [
          '노바소프트그룹/ICT본부',
          'hostnm_1000',
          '16.112.22.22',
          'WINDOWS',
          'windows2012',
          '노바_1000_windows2012',
          '노바소프트그룹/인프라운영팀 시스템운영',
          '윤서연',
          '노바소프트그룹/인프라운영팀 시스템운영',
          '전지율',
          '점검대기중',
          ' ',
          '점검 이력이 없습니다.',
      ],
  ];

  var UserSetting_dataSet = [
      [
          '<input type="checkbox" class="checked">',
          '2020110',
          '김지호',
          '마블시스템',
          '개발1팀',
          '12341234',
          '대리',
          '관리자',
          'alex@marvelsystem.co.kr'
      ],
      [
          '<input type="checkbox" class="checked">',
          '2020110',
          '김지호',
          '마블시스템',
          '영업3팀',
          '12341234',
          '대리',
          '관리자',
          'alex@marvelsystem.co.kr'
      ],
      [
          '<input type="checkbox" class="checked">',
          '2020110',
          '김지호',
          '마블시스템',
          '영업2팀',
          '12341234',
          '대리',
          '관리자',
          'alex@marvelsystem.co.kr'
      ],
      [
          '<input type="checkbox" class="checked">',
          '2020110',
          '김지호',
          '마블시스템',
          '영업1팀',
          '12341234',
          '대리',
          '관리자',
          'alex@marvelsystem.co.kr'
      ],
      [
          '<input type="checkbox" class="checked">',
          '2020110',
          '김지호',
          '마블시스템',
          '관리팀',
          '12341234',
          '대리',
          '관리자',
          'alex@marvelsystem.co.kr'
      ],
      [
          '<input type="checkbox" class="checked">',
          '2020110',
          '김지호',
          '마블시스템',
          '영업지원팀',
          '12341234',
          '대리',
          '관리자',
          'alex@marvelsystem.co.kr'
      ],
      [
          '<input type="checkbox" class="checked">',
          '2020110',
          '김지호',
          '마블시스템',
          '개발2팀',
          '12341234',
          '대리',
          '관리자',
          'alex@marvelsystem.co.kr'
      ],
      [
          '<input type="checkbox" class="checked">',
          '2020110',
          '김지호',
          '마블시스템',
          '엔지니어팀',
          '12341234',
          '대리',
          '관리자',
          'alex@marvelsystem.co.kr'
      ],
      [
          '<input type="checkbox" class="checked">',
          '2020110',
          '김지호',
          '마블시스템',
          '영업지원팀',
          '12341234',
          '대리',
          '관리자',
          'alex@marvelsystem.co.kr'
      ],
  ];




  // Korean
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


  $('#UserSetting_dataTable').DataTable( {
      language : lang_kor,
      ordering : false,
      scrollX : "100%",
      sScrollXInner: "1000px",
      dom: "<'row'<'col-xl-12 col-lg-7 no-padding'lfrBtip>>",
      buttons:buttons,
      ajax : {
          "type" : "GET",
          "url" : "getUserDatatable.do",
          "dataType" : "JSON",
      },
      columns : [
          {
              data : "uid",
              defaultContent:"",
              'targets': 0,
              'searchable': false,
              'className': 'dt-2',
              "render": function (data, type, row) {
                  return '<input type="checkbox" data-uid="'+data+'" value="'+data+'" class="checked">';
              }
            },
          {data : "uid", 'className': 'dt-6'},
          {data : "email", 'className': ''},
          {data : "name", 'className': 'dt-10'},
          {data : "corp", 'className': 'dt-16'},
          {data : "department", 'className': 'dt-16'},
          {data : "ranks"},
          {data : "codes"},
          {data : "status"},
          {data : "i_group", 'orderable': false, 'className': 'dt-6'},
      ],
  });

  $('#user_setting .tree_val').click(function(e) {
     e.preventDefault();
     var val = $(this).attr('value');
     $('#UserSetting_dataTable').DataTable( {
         destroy: true,
         "search": {
          "search" : val
        },
         language : lang_kor,
          ordering : false,
          scrollX : "100%",
          sScrollXInner: "1000px",
          dom: "<'row'<'col-xl-12 col-lg-7 no-padding'lfrBtip>>",
          buttons:buttons,
          ajax : {
              "type" : "POST",
              "url" : "getUserDatatable.do",
              "dataType" : "JSON",
          },
          columns : [
              {
                  data : "uid",
                  defaultContent:"",
                  'targets': 0,
                  'searchable': false,
                  'className': 'dt-2',
                  "render": function (data, type, row) {
                      return '<input type="checkbox" data-uid="'+data+'" value="'+data+'" class="checked">';
                  }
                },
              {data : "uid", 'className': 'dt-6'},
              {data : "email", 'className': ''},
              {data : "name", 'className': 'dt-10'},
              {data : "corp", 'className': 'dt-16'},
              {data : "department", 'className': 'dt-16'},
              {data : "ranks"},
              {data : "codes"},
              {data : "status"},
              {data : "i_group", 'orderable': false, 'className': 'dt-6'},
          ],
     });
  });


  $('#OrgSetting_dataTable').DataTable( {
      language : lang_kor,
      ordering : false,
      scrollX : "100%",
      sScrollXInner: "1200px",
      dom: "<'row'<'col-xl-12 col-lg-7 no-padding'lfrBtip>>",
      buttons:buttons,
      ajax : {
          "type" : "POST",
          "url" : "getOrgDatatable.do",
          "dataType" : "JSON",
      },
      columns : [
          {
              data : "oid",
              defaultContent:"",
              'targets': 0,
              'searchable': false,
              'className':'dt-2',
              "render": function (data) {
                  return '<input type="checkbox" data-oid="'+data+'" value="'+data+'" class="checked">';
              }
            },
          {data : "oid", 'className': 'dt-5'},
          {data : "codes"},
          {data : "name"},
          {data : "ocode"},
          {data : "oname"},
          {data : "oengName"},
          {data : "upperCode"},
          {data : "upperName"},
          {data : "status"},
          {data : "orders"},
          {data : "topcheck",
          "render": function (data) {
                if(data) { return "O"; } else { return ""; }
            }
          },
      ],
  });


  $('#org_setting ul.depth_3 li a').click(function(e) {
     e.preventDefault();
     var val = $(this).attr('value');
     $('#OrgSetting_dataTable').DataTable( {
         destroy: true,
         "search": {
          "search" : val
        },
         language : lang_kor,
          ordering : false,
          scrollX : "100%",
          sScrollXInner: "1200px",
          dom: "<'row'<'col-xl-12 col-lg-7 no-padding'lfrBtip>>",
          buttons:buttons,
          ajax : {
              "type" : "POST",
              "url" : "getOrgDatatable.do",
              "dataType" : "JSON",
          },
          columns : [
              {
                  data : "oid",
                  defaultContent:"",
                  'targets': 0,
                  'searchable': false,
                  'className': 'dt-2',
                  "render": function (data) {
                      return '<input type="checkbox" data-oid="'+data+'" value="'+data+'" class="checked">';
                  }
                },
              {data : "oid", 'className': 'dt-5'},
              {data : "codes"},
              {data : "name"},
              {data : "oCode"},
              {data : "oName"},
              {data : "oengName"},
              {data : "upperCode"},
              {data : "upperName"},
              {data : "status"},
              {data : "orders"},
              {data : "topcheck",
              "render": function (data) {
                    if(data) { return "O"; } else { return ""; }
                }
              },
          ],
     });
  });

});

