<div class="se_editArea">
        	<div class="se_viewArea se_ff_nanumgothic se_fs_D2">
	            <div class="se_editView se_title">
	                <div class="se_textView">
                        <h3 class="se_textarea">
                            <!-- -->[자료구조] 트라이 (Trie)<!-- -->
                        </h3>

	                </div>
	            </div>
	        </div>
        </div>
<div class="se_editArea">
            <div class="se_viewArea se_ff_nanumgothic se_fs_T3 se_align-left">
                <div class="se_editView">
                    <div class="se_textView">
                        <p class="se_textarea"><!-- SE3-TEXT { --><span>빠른 단어 검색을 위한 자료구조인 트라이에 대해 알아봅시다. 이번에도 샘플 코드를 깃허브에 올려두었습니다. <a class="se_link" href="https://github.com/Lenir/TIL/blob/master/Data-Structure/data-Structure_python/Trie.py" target="_blank">링크</a> 해 드리겠습니다. </span><!-- } SE3-TEXT --></p>
                    </div>
                </div>
            </div>
        </div>
<div class="se_editArea" id="SEDOC-1512888372038--1903533366_oglink_0">
            <div class="se_viewArea se_og_wrap">
                <a class="se_og_box __se_link" data-linkdata='{"link" : "https://github.com/Lenir/TIL/blob/master/Data-Structure/data-Structure_python/Trie.py"}' data-linktype="link" href="https://github.com/Lenir/TIL/blob/master/Data-Structure/data-Structure_python/Trie.py" target="_blank">
                    <div class="se_og_thumb">
                        <img alt="" src="https://dthumb-phinf.pstatic.net/?src=%22https%3A%2F%2Favatars2.githubusercontent.com%2Fu%2F12121335%3Fs%3D400%26v%3D4%22&amp;type=ff120"/>
					</div>
                    <div class="se_og_txt">
                            <div class="se_og_tit">Lenir/TIL</div>
                                <div class="se_og_desc">TIL - Repository for push 'Today I Learned'!</div>
                            <div class="se_og_cp">github.com</div>

                    </div>
                </a>
            </div>
        </div>
<div class="se_editArea">
            <div class="se_viewArea se_ff_nanumgothic se_fs_T3 se_align-left">
                <div class="se_editView">
                    <div class="se_textView">
                        <p class="se_textarea"><!-- SE3-TEXT { --><span>단어를 저장하기 위해서 어떤 자료구조를 쓰는 것이 유리할까요? 간단하게 배열에다가 싸그리 저장해도 될 겁니다. 이런 경우에는 자료가 이런 식으로 쌓일 겁니다.<br/></span><span></span><!-- } SE3-TEXT --></p>
                    </div>
                </div>
            </div>
        </div>
<div class="se_editArea">
					<div class="se_viewArea" style="max-width:324px">
						<a class="se_mediaArea __se_image_link __se_link" data-linkdata='{"imgId" : "SEDOC-1512888372038--1903533366_image_0_img", "src" : "https://postfiles.pstatic.net/MjAxNzEyMDZfMjk5/MDAxNTEyNTUxMTM1MTE3.nUXkrsxxfaWhAmI1ANgL0n0W7t8EoX3uJWUW_ZTvBYAg.wLDiiCLdtL4EMw_ydsUpdXH5rQwfrL2sQA3FnISub3Mg.PNG.1net1/image.png", "linkUse" : "false", "link" : ""}' data-linktype="img" href="#" onclick="return false;">
							<img alt="" class="se_mediaImage __se_img_el" data-attachment-id="Id-TydDKugoaz56EOBCISOw3dpQo" height="386" id="SEDOC-1512888372038--1903533366_image_0_img" src="https://postfiles.pstatic.net/MjAxNzEyMDZfMjk5/MDAxNTEyNTUxMTM1MTE3.nUXkrsxxfaWhAmI1ANgL0n0W7t8EoX3uJWUW_ZTvBYAg.wLDiiCLdtL4EMw_ydsUpdXH5rQwfrL2sQA3FnISub3Mg.PNG.1net1/image.png?type=w966" width="324"/>
						</a>
							<div class="se_editView">
								<div class="se_textView se_mediaCaption">
									    <span class="se_textarea">아주 이쁘게 쌓여 있습니다</span>
								</div>
							</div>
					</div>
				</div>
<div class="se_editArea">
            <div class="se_viewArea se_ff_nanumgothic se_fs_T3 se_align-left">
                <div class="se_editView">
                    <div class="se_textView">
                        <p class="se_textarea"><!-- SE3-TEXT { --><span>네 아주 좋습니다. 이렇게 배열에 쌓아두고 찾으려면 간단하게 처음부터 찾게 되겠죠. 그러면 탐색에 걸리는 Time Complexity는 worst-cast 에서 </span><span><i>O(N)</i></span><span>이 됩니다. 내가 원하는 단어인 </span><span><i>'슾햄'</i></span><span>이 배열 마지막에 들어 있을 수도 있잖아요? 별로 좋은 방법은 아닌 것 같습니다. 그래도 구현하기 쉬우니 일단은 참아줍시다. 그런데 앞부분이 중복되는 단어가 많다면 어떻게 저장될까요? 극단적으로 다음과 같은 예를 봅시다.<br/></span><span></span><span></span><!-- } SE3-TEXT --></p>
                    </div>
                </div>
            </div>
        </div>
<div class="se_editArea">
					<div class="se_viewArea" style="max-width:320px">
						<a class="se_mediaArea __se_image_link __se_link" data-linkdata='{"imgId" : "SEDOC-1512888372038--1903533366_image_1_img", "src" : "https://postfiles.pstatic.net/MjAxNzEyMDZfMjg3/MDAxNTEyNTUxMjExNTM5.VKn4DSGwtedKgiOEFEpknG0zRlWZ8aXGOy06LgYF1q0g.qtl9NqwScTzVNR444cMuFSHlrSFg9mO7SJLXQYeqZ4og.PNG.1net1/image.png", "linkUse" : "false", "link" : ""}' data-linktype="img" href="#" onclick="return false;">
							<img alt="" class="se_mediaImage __se_img_el" data-attachment-id="I75zSgwzTBAmIx78Rq0Tp_g-seVk" height="386" id="SEDOC-1512888372038--1903533366_image_1_img" src="https://postfiles.pstatic.net/MjAxNzEyMDZfMjg3/MDAxNTEyNTUxMjExNTM5.VKn4DSGwtedKgiOEFEpknG0zRlWZ8aXGOy06LgYF1q0g.qtl9NqwScTzVNR444cMuFSHlrSFg9mO7SJLXQYeqZ4og.PNG.1net1/image.png?type=w966" width="320"/>
						</a>
							<div class="se_editView">
								<div class="se_textView se_mediaCaption">
									    <span class="se_textarea">슾햄 종합 선물 세트</span>
								</div>
							</div>
					</div>
				</div>
<div class="se_editArea">
            <div class="se_viewArea se_ff_nanumgothic se_fs_T3 se_align-left">
                <div class="se_editView">
                    <div class="se_textView">
                        <p class="se_textarea"><!-- SE3-TEXT { --><span>앞의 네 글자는 모두 같은데 뒤에 한 두 글자만 달라서 모두 공간을 따로 차지합니다. 단어를 찾을 때 빠르지도 않고 쓸데없이 중복되는 단어로 공간도 많이 차지하죠. 아주 데-단한 시스템이 될 겁니다.<br/></span><span>이를 해결하기 위한 자료구조가 바로 </span><span><i>트라이</i></span><span><i><sub>Trie</sub></i></span><span> 입니다. 이름이 꼭 트리같은 느낌이죠. 그래서 그런지 트라이도 트리의 일종입니다. 그림으로 한번 봅시다.<br/></span><span></span><!-- } SE3-TEXT --></p>
                    </div>
                </div>
            </div>
        </div>
<div class="se_editArea">
					<div class="se_viewArea" style="max-width:382px">
						<a class="se_mediaArea __se_image_link __se_link" data-linkdata='{"imgId" : "SEDOC-1512888372038--1903533366_image_2_img", "src" : "https://postfiles.pstatic.net/MjAxNzEyMDZfMjI2/MDAxNTEyNTUxNjc4MzI4.VNcz23Tl495_9o2HTJ0Qm5HW_H-CufZs_h5NaPZ8cMcg.geR-Xubs3hBCzgRdwsBkWCXmZODEW-jxnhHfwzfnpCIg.PNG.1net1/image.png", "linkUse" : "false", "link" : ""}' data-linktype="img" href="#" onclick="return false;">
							<img alt="" class="se_mediaImage __se_img_el" data-attachment-id="IPwNu_aqEHenRQY1rOj_081V7R_g" height="573" id="SEDOC-1512888372038--1903533366_image_2_img" src="https://postfiles.pstatic.net/MjAxNzEyMDZfMjI2/MDAxNTEyNTUxNjc4MzI4.VNcz23Tl495_9o2HTJ0Qm5HW_H-CufZs_h5NaPZ8cMcg.geR-Xubs3hBCzgRdwsBkWCXmZODEW-jxnhHfwzfnpCIg.PNG.1net1/image.png?type=w966" width="382"/>
						</a>
							<div class="se_editView">
								<div class="se_textView se_mediaCaption">
									    <span class="se_textarea">트라이</span>
								</div>
							</div>
					</div>
				</div>
<div class="se_editArea">
            <div class="se_viewArea se_ff_nanumgothic se_fs_T3 se_align-left">
                <div class="se_editView">
                    <div class="se_textView">
                        <p class="se_textarea"><!-- SE3-TEXT { --><span>위 트라이는 SPAM, Egg, Ego를 저장하고 있고, 맨 위의 노드는 루트 노드 입니다. 보시면 대략 감이 오실 겁니다. 단어의 첫 글자부터 글자마다 Child 노드로 이어 붙인 겁니다. 글자가 같다면 노드를 쭈욱 따라가다가 다른 글자가 나오면 새 Child 노드를 만들어 갈라지는 식 입니다. 그러면 이 트라이를 썼을때의 단어 검색 Time Complexity는 어떨까요? 아니 그 전에 SPAM을 찾아 보려면 어떻게 하면 될까요?<br/></span><span></span><!-- } SE3-TEXT --></p>
                    </div>
                </div>
            </div>
        </div>
<div class="se_editArea">
					<div class="se_viewArea" style="max-width:448px">
						<a class="se_mediaArea __se_image_link __se_link" data-linkdata='{"imgId" : "SEDOC-1512888372038--1903533366_image_3_img", "src" : "https://postfiles.pstatic.net/MjAxNzEyMDZfMTMz/MDAxNTEyNTUyOTYxNDQ0.CQgnXZmQBSB4ja-gPB54QLiIs5hzJW0S2G7SlejDIzsg.O6D_DCl4OOgy_9uuKu2hEQn712Ql6X8QNfLDdoIaylwg.PNG.1net1/image.png", "linkUse" : "false", "link" : ""}' data-linktype="img" href="#" onclick="return false;">
							<img alt="" class="se_mediaImage __se_img_el" data-attachment-id="Ipo9OThy08UQHjqq9-U4oVHt0LIg" height="604" id="SEDOC-1512888372038--1903533366_image_3_img" src="https://postfiles.pstatic.net/MjAxNzEyMDZfMTMz/MDAxNTEyNTUyOTYxNDQ0.CQgnXZmQBSB4ja-gPB54QLiIs5hzJW0S2G7SlejDIzsg.O6D_DCl4OOgy_9uuKu2hEQn712Ql6X8QNfLDdoIaylwg.PNG.1net1/image.png?type=w966" width="448"/>
						</a>
							<div class="se_editView">
								<div class="se_textView se_mediaCaption">
									    <span class="se_textarea">root, S, P, A, M</span>
								</div>
							</div>
					</div>
				</div>
<div class="se_editArea">
            <div class="se_viewArea se_ff_nanumgothic se_fs_T3 se_align-left">
                <div class="se_editView">
                    <div class="se_textView">
                        <p class="se_textarea"><!-- SE3-TEXT { --><span>위의 그림처럼 하면 될 것 같습니다. (</span><span><b>root</b></span><span>) - </span><span><b>S</b></span><span> - </span><span><b>P</b></span><span> - </span><span><b>A</b></span><span> - </span><span><b>M</b></span><span>. 존재하네요! 즉</span><span><i> O(l)</i></span><span><i><span style="color: rgb(0, 0, 0);"><sub>(l은 단어의 길이)</sub></span></i></span><span> 의 시간이 걸릴 겁니다. 즉 찾으려는 단어의 길이 만큼 들겠네요. 이정도면 훌륭한 검색시간인 것 같습니다. <br/></span><span>그러면 시간은 괜찮다 치고 저장 공간은 어떨까요? Trie를 구현하고 테스트 해 봅시다. Trie 클래스 구현 코드는 위의 링크에 있습니다. </span><span><br/></span><span></span><!-- } SE3-TEXT --></p>
                    </div>
                </div>
            </div>
        </div>
<div class="se_editArea">
            <div class="se_viewArea se_fs_T3 ">
                <div class="se_editView">
                    <div class="se_textView">
                        <div class="__se_code_view se_textarea language-javascript">if __name__ == "__main__":
    trie = Trie()
    trie.insertWord("SPAM")
    trie.insertWord("SPAM!")
    trie.insertWord("SPAM?")
    trie.insertWord("SPAM*")
    trie.insertWord("SPAM.")
    trie.insertWord("SPAM;")

    print(trie.getWords())
    print(trie.getNodeNum())</div>
                    </div>
                </div>
            </div>
        </div>
<div class="se_editArea">
            <div class="se_viewArea se_ff_nanumgothic se_fs_T3 se_align-left">
                <div class="se_editView">
                    <div class="se_textView">
                        <p class="se_textarea"><!-- SE3-TEXT { --><span>테스트용 코드를 위와 같이 작성하였습니다. 코드과 같이 여섯개의 단어를 넣어 봅시다. 배열로 저장했다면 저 여섯 단어가 다 따로 저장되어 있을 겁니다. 그러면 트라이로 저장했을때는 어떻게 될까요? 정확한 Byte수를 따지기 보단 노드의 갯수를 봅시다. 노드의 갯수가 적을수록 저장공간을 덜 먹겠죠. <br/></span><span></span><!-- } SE3-TEXT --></p>
                    </div>
                </div>
            </div>
        </div>
<div class="se_editArea">
					<div class="se_viewArea" style="max-width:296px">
						<a class="se_mediaArea __se_image_link __se_link" data-linkdata='{"imgId" : "SEDOC-1512888372038--1903533366_image_4_img", "src" : "https://postfiles.pstatic.net/MjAxNzEyMDZfMjU5/MDAxNTEyNTUyNDQ2Nzgw.OxAO6j7yNSGYTUrvW5-ZaCq6BEwzh2i98h6WQmoHRlwg.svckVbz0_pBQU4zrlZDh5Yo6ED-hP8m5rlpTl7VobKsg.PNG.1net1/image.png", "linkUse" : "false", "link" : ""}' data-linktype="img" href="#" onclick="return false;">
							<img alt="" class="se_mediaImage __se_img_el" data-attachment-id="IKAxe9PNwynoxNCxgI_WLATnzTIU" height="47" id="SEDOC-1512888372038--1903533366_image_4_img" src="https://postfiles.pstatic.net/MjAxNzEyMDZfMjU5/MDAxNTEyNTUyNDQ2Nzgw.OxAO6j7yNSGYTUrvW5-ZaCq6BEwzh2i98h6WQmoHRlwg.svckVbz0_pBQU4zrlZDh5Yo6ED-hP8m5rlpTl7VobKsg.PNG.1net1/image.png?type=w966" width="296"/>
						</a>
							<div class="se_editView">
								<div class="se_textView se_mediaCaption">
									    <span class="se_textarea">슾햄 선물세트 2</span>
								</div>
							</div>
					</div>
				</div>
<div class="se_editArea">
            <div class="se_viewArea se_ff_nanumgothic se_fs_T3 se_align-left">
                <div class="se_editView">
                    <div class="se_textView">
                        <p class="se_textarea"><!-- SE3-TEXT { --><span>첫 라인은 트라이에 단어가 제대로 들어갔는지 print한 것이고 두번째 라인이 현재 트라이의 노드의 갯수입니다. 10개로 나옵니다. 4글자 단어 하나와 5글자 단어 5개를 저장했는데 겨우 10 노드밖에 쓰지 않네요! 직접 한번 그려 가며 세어 봅시다. 이 녀석이 어디 노드를 숨겨 놓은게 아닌지! </span><span><br/></span><span></span><!-- } SE3-TEXT --></p>
                    </div>
                </div>
            </div>
        </div>
<div class="se_editArea">
					<div class="se_viewArea" style="max-width:395px">
						<a class="se_mediaArea __se_image_link __se_link" data-linkdata='{"imgId" : "SEDOC-1512888372038--1903533366_image_5_img", "src" : "https://postfiles.pstatic.net/MjAxNzEyMDZfMjQy/MDAxNTEyNTUzNzAxMjA0.nL5LMD9uCIIZvv3Q9BsJjacrMmC_l1spqPf0c_2p7C0g.ax9BT8YRqCRloNA6H2iB7AgaieMAs5Rv5Yqa3lU-tVAg.JPEG.1net1/Tazza.The.High.Rollers.2006.720p.BluRay.x264-CHD.mkv_20151229_173637.227.jpg", "linkUse" : "false", "link" : ""}' data-linktype="img" href="#" onclick="return false;">
							<img alt="" class="se_mediaImage __se_img_el" data-attachment-id="ItJfOkR6dsl2Fw5-GXBvSl6VuIsk" height="170" id="SEDOC-1512888372038--1903533366_image_5_img" src="https://postfiles.pstatic.net/MjAxNzEyMDZfMjQy/MDAxNTEyNTUzNzAxMjA0.nL5LMD9uCIIZvv3Q9BsJjacrMmC_l1spqPf0c_2p7C0g.ax9BT8YRqCRloNA6H2iB7AgaieMAs5Rv5Yqa3lU-tVAg.JPEG.1net1/Tazza.The.High.Rollers.2006.720p.BluRay.x264-CHD.mkv_20151229_173637.227.jpg?type=w966" width="395"/>
						</a>
							<div class="se_editView">
								<div class="se_textView se_mediaCaption">
									    <span class="se_textarea">예림이 그 노드 갯수 봐봐 혹시 10개야?</span>
								</div>
							</div>
					</div>
				</div>
<div class="se_editArea">
            <div class="se_viewArea se_ff_nanumgothic se_fs_T3 se_align-left">
                <div class="se_editView">
                    <div class="se_textView">
                        <p class="se_textarea"><!-- SE3-TEXT { --><span></span><span>아, 다시 말해드리는 거지만 트라이는 단어의 첫 글자부터 같은 글자일 경우 노드를 타고 넘어가다 다른 글자가 나올 경우 <span style="color: rgb(0, 0, 0);">새 Child 노드를 만들어 </span>가지치기를 합니다!</span><span></span><!-- } SE3-TEXT --></p>
                    </div>
                </div>
            </div>
        </div>
<div class="se_editArea">
					<div class="se_viewArea" style="max-width:522px">
						<a class="se_mediaArea __se_image_link __se_link" data-linkdata='{"imgId" : "SEDOC-1512888372038--1903533366_image_6_img", "src" : "https://postfiles.pstatic.net/MjAxNzEyMDZfMjc0/MDAxNTEyNTUyNjg1ODQy.Vrm2uKClcVnEsv3i6OLnUKGahND8LDi_mTwRRyWLM8Ig.hveTy2ZjwXir4gaxelXKMRRBvgVR_G0EBrEgMoF2oRgg.PNG.1net1/image.png", "linkUse" : "false", "link" : ""}' data-linktype="img" href="#" onclick="return false;">
							<img alt="" class="se_mediaImage __se_img_el" data-attachment-id="IPI4HrZCNPLo5Pk-efitktcUHjH0" height="535" id="SEDOC-1512888372038--1903533366_image_6_img" src="https://postfiles.pstatic.net/MjAxNzEyMDZfMjc0/MDAxNTEyNTUyNjg1ODQy.Vrm2uKClcVnEsv3i6OLnUKGahND8LDi_mTwRRyWLM8Ig.hveTy2ZjwXir4gaxelXKMRRBvgVR_G0EBrEgMoF2oRgg.PNG.1net1/image.png?type=w966" width="522"/>
						</a>
							<div class="se_editView">
								<div class="se_textView se_mediaCaption">
									    <span class="se_textarea">슾햄 슾햄! 슾햄? 슾햄* 슾햄. 슾햄;</span>
								</div>
							</div>
					</div>
				</div>
<div class="se_editArea">
            <div class="se_viewArea se_ff_nanumgothic se_fs_T3 se_align-left">
                <div class="se_editView">
                    <div class="se_textView">
                        <p class="se_textarea"><!-- SE3-TEXT { -->{ <b>root</b> / <b>S</b> / <b>P</b> / <b>A</b> / <b>M</b> / <b>!</b> / <b>?</b> / <b>*</b> / <b>.</b> / <b>;</b><span> }  10개 맞는거 같습니다! </span><br/><!-- } SE3-TEXT --></p>
                    </div>
                </div>
            </div>
        </div>
<div class="se_editArea">
					<div class="se_viewArea" style="max-width:299px">
						<a class="se_mediaArea __se_image_link __se_link" data-linkdata='{"imgId" : "SEDOC-1512888372038--1903533366_image_7_img", "src" : "https://postfiles.pstatic.net/MjAxNzEyMDZfMjU5/MDAxNTEyNTU0NTQyNDIx.3TFEGfcbNmbZtJZ8QqEPk6nwvClFsjm77_3pfV0yyREg.lqvY_WTMsBqw8MgAoehp1T807yzjHvMyQUAszgMQSqEg.JPEG.1net1/image_5811830611512554510523.jpg", "linkUse" : "false", "link" : ""}' data-linktype="img" href="#" onclick="return false;">
							<img alt="" class="se_mediaImage __se_img_el" data-attachment-id="IS_bPvySKFOV3-t7YKeryRXCqZK8" height="191" id="SEDOC-1512888372038--1903533366_image_7_img" src="https://postfiles.pstatic.net/MjAxNzEyMDZfMjU5/MDAxNTEyNTU0NTQyNDIx.3TFEGfcbNmbZtJZ8QqEPk6nwvClFsjm77_3pfV0yyREg.lqvY_WTMsBqw8MgAoehp1T807yzjHvMyQUAszgMQSqEg.JPEG.1net1/image_5811830611512554510523.jpg?type=w966" width="299"/>
						</a>
					</div>
				</div>
<div class="se_editArea">
            <div class="se_viewArea se_ff_nanumgothic se_fs_T3 se_align-left">
                <div class="se_editView">
                    <div class="se_textView">
                        <p class="se_textarea"><!-- SE3-TEXT { --><span style="color: rgb(0, 0, 0);">만약 저걸 배열처럼 따로따로 저장했다면</span><i style=" color: rgb(0, 0, 0)"><sub><span> </span>-물론 비교 할 만 한건 아니지만-</sub></i><span style="color: rgb(0, 0, 0);"><span> </span>4+5+5+5+5+5,</span><b style=" color: rgb(0, 0, 0)"><span> </span>29개</b><span style="color: rgb(0, 0, 0);">의 글자를 따로 저장해야 했을 겁니다. 겨우 다섯개의 중복으로도 이정도로 늘어나는데, 검색엔진처럼 매우 많은 사람들이 이용하는 서비스라면 엄청 심하겠죠. <br/></span><span style="color: rgb(0, 0, 0);">간단하게 트라이를 살펴 봤습니다. 구현 코드가 궁금하시다면 포스팅 상단에 있는 깃허브 링크를 참조해주세요. 간단한 코드라 별 건 없을 겁니다. 멍 때리며 코딩했더니 코드 상태가 좀 지저분하긴 하네요.<br/></span><span style="color: rgb(0, 0, 0);"></span><!-- } SE3-TEXT --></p>
                    </div>
                </div>
            </div>
        </div>
