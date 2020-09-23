$(() => {
  $("#alert-success").hide();
  $("#alert-fail").hide();
  $("input").keyup(() => {
    const password1 = $("input[name*='password1']").val();
    const password2 = $("input[name*='password2']").val();
    if (password1 !== "" || password2 !== "") {
      if (password1 === password2) {
        $("#alert-success").show();
        $("#alert-fail").hide();
      } else {
        $("#alert-success").hide();
        $("#alert-fail").show();
      }
    }
  });
});

const plusNumber = () => {
  const nowData = Number($("#numplus").val());
  if (isNaN(nowData)) {
    alert("숫자만 입력가능합니다.");
  } else {
    $("#numplus").val(nowData + 1);
  }
};
