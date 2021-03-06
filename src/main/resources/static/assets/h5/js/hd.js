$(document).ready(function(e) {
			//设置最大值
			ScrollBar.maxValue=100;
			//初始化
			ScrollBar.Initialize();
		});
		var ScrollBar = {
			value: 20,
			maxValue: 100,
			step: 1,
			currentX: 0,
			Initialize: function() {
				if (this.value > this.maxValue) {
					alert("给定当前值大于了最大值");
					return;
				}
				this.GetValue();
				$("#scroll_Track").css("width", this.currentX + 2 + "px");
				$("#scroll_Thumb").css("margin-left", this.currentX + "px");
				this.Value();
				$("#scrollBarTxt").html(ScrollBar.value + "/" + ScrollBar.maxValue);
			},
			Value: function() {
				var valite = false;
				var currentValue;
				$("#scroll_Thumb").mousedown(function() {
					valite = true;
					$(document.body).mousemove(function(event) {
						if (valite == false) return;
						var changeX = event.clientX - ScrollBar.currentX;
						currentValue = changeX - ScrollBar.currentX-$("#Demo").offset().left;
						$("#scroll_Thumb").css("margin-left", currentValue + "px");
						$("#scroll_Track").css("width", currentValue + 2 + "px");
						if ((currentValue + 25) >= $("#scrollBar").width()) {
							$("#scroll_Thumb").css("margin-left", $("#scrollBar").width() - 25 + "px");
							$("#scroll_Track").css("width", $("#scrollBar").width() + 2 + "px");
							ScrollBar.value = ScrollBar.maxValue;
						} else if (currentValue <= 0) {
							$("#scroll_Thumb").css("margin-left", "0px");
							$("#scroll_Track").css("width", "0px");
						} else {
							ScrollBar.value = Math.round(100 * (currentValue / $("#scrollBar").width()));
						}
						$("#scrollBarTxt").html(ScrollBar.value + "/" + ScrollBar.maxValue);
					});
				});
				$(document.body).mouseup(function() {
					ScrollBar.value = Math.round(100 * (currentValue / $("#scrollBar").width()));
					valite = false;
					if (ScrollBar.value >= ScrollBar.maxValue) ScrollBar.value = ScrollBar.maxValue;
					if (ScrollBar.value <= 0) ScrollBar.value = 0;
					$("#scrollBarTxt").html(ScrollBar.value + "/" + ScrollBar.maxValue);
				});
			},
			GetValue: function() {
				this.currentX = $("#scrollBar").width() * (this.value / this.maxValue);
			}
		}
